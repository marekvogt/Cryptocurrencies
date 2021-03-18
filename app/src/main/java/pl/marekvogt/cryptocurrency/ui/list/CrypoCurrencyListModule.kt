package pl.marekvogt.cryptocurrency.ui.list

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
interface CryptoCurrencyListModule {

    @Binds
    fun bindCryptoCurrencyMapper(mapper: DefaultCryptoCurrencyRateMapper): CryptoCurrencyRateMapper
}