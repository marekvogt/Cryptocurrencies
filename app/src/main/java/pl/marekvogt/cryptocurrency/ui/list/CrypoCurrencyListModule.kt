package pl.marekvogt.cryptocurrency.ui.list

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
interface CryptoCurrencyListModule {

    @Binds
    fun bindCryptoCurrencyMapper(mapper: DefaultCryptoCurrencyRateMapper): CryptoCurrencyRateMapper
}