package pl.marekvogt.cryptocurrency.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pl.marekvogt.cryptocurrency.domain.repository.BaseCurrencyRepository
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCachedRepository
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
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