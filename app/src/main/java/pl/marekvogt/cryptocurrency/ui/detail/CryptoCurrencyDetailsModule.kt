package pl.marekvogt.cryptocurrency.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.viewmodel.ViewModelFactory
import javax.inject.Named

@Module(includes = [CryptoCurrencyDetailsModule.ViewModelFactoryModule::class])
object CryptoCurrencyDetailsModule {

    @Provides
    @FragmentScope
    @JvmStatic
    fun provideCryptoCurrencyDetailsMapper(
        context: Context
    ): CryptoCurrencyDetailsMapper = DefaultCryptoCurrencyDetailsMapper(context)

    @Provides
    @FragmentScope
    @JvmStatic
    @IntoMap
    @ViewModelKey(CryptoCurrencyDetailsViewModel::class)
    fun provideCryptoCurrencyDetailsViewModel(
        mapper: CryptoCurrencyDetailsMapper
    ): ViewModel = CryptoCurrencyDetailsViewModel(mapper)

    @Module
    interface ViewModelFactoryModule {
        @Binds
        @FragmentScope
        @Named("ViewModelFactory.Details")
        fun provideCryptoCurrencyDetailsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
    }
}