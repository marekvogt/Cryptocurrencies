package pl.marekvogt.cryptocurrency.data

import dagger.Binds
import dagger.Module
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCachedRepository
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindCryptoCurrenciesRepository(
        cryptoCurrenciesRepository: CryptoCurrenciesRestRepository
    ): CryptoCurrenciesCachedRepository
}