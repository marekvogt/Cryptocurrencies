package pl.marekvogt.cryptocurrency.ui.detail

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
interface CryptoCurrencyDetailsModule {

    @Binds
    fun bindCryptoCurrencyDetailsMapper(mapper: DefaultCryptoCurrencyDetailsMapper): CryptoCurrencyDetailsMapper
}