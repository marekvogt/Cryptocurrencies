package pl.marekvogt.cryptocurrency.data

import dagger.Binds
import dagger.Module
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCacheableRepository
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindCryptoCurrenciesRepository(
        cryptoCurrenciesRepository: CryptoCurrenciesRestRepository
    ): CryptoCurrenciesCacheableRepository
}