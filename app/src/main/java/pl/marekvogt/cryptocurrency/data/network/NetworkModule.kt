package pl.marekvogt.cryptocurrency.data.network

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.marekvogt.cryptocurrency.data.CryptoCurrencyRatesDeserializer
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRates
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun cryptoCurrenciesService(
        retrofit: Retrofit
    ): CryptoCurrenciesService = retrofit.create(CryptoCurrenciesService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(CryptoCurrencyRates::class.java, CryptoCurrencyRatesDeserializer())
            .create()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.coingecko.com/")
            .build()
    }
}