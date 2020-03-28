package pl.marekvogt.cryptocurrency.data

import dagger.Binds
import dagger.Module
import pl.marekvogt.cryptocurrency.domain.repository.BaseCurrencyRepository
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCachedRepository
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindCryptoCurrenciesRepository(
        cryptoCurrenciesRepository: CryptoCurrenciesRestRepository
    ): CryptoCurrenciesCachedRepository

    @Binds
    @Singleton
    fun bindBaseCurrencyRepository(
        baseCurrencyRepository: BaseCurrencyLocalRepository
    ): BaseCurrencyRepository
}