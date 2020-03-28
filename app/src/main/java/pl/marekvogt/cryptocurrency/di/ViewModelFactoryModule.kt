package pl.marekvogt.cryptocurrency.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import pl.marekvogt.cryptocurrency.ui.common.DaggerViewModelFactory
import pl.marekvogt.cryptocurrency.ui.detail.CryptoCurrencyDetailsModule
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyListModule

@Module(
    includes = [
        CryptoCurrencyListModule::class,
        CryptoCurrencyDetailsModule::class
    ]
)
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}