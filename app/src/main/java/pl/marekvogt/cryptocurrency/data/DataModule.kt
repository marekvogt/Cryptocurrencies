package pl.marekvogt.cryptocurrency.data

import dagger.Module
import dagger.Provides
import pl.marekvogt.cryptocurrency.data.network.CryptoCurrenciesService
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCacheableRepository
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideCryptoCurrenciesRepository(
        service: CryptoCurrenciesService
    ): CryptoCurrenciesCacheableRepository = CryptoCurrenciesRestRepository(service)
}