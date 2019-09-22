package pl.marekvogt.cryptocurrency.data

import dagger.Module
import dagger.Provides
import pl.marekvogt.cryptocurrency.data.network.CryptoCurrenciesService
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesRepository
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideCryptoCurrenciesRepository(
        service: CryptoCurrenciesService
    ): CryptoCurrenciesRepository = CryptoCurrenciesRestRepository(service)
}