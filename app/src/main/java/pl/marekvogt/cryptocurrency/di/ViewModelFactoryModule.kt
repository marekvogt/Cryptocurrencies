package pl.marekvogt.cryptocurrency.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import pl.marekvogt.cryptocurrency.viewmodel.ViewModelFactory

@Module
interface ViewModelFactoryModule {

    @Binds
    fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}