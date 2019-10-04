package pl.marekvogt.cryptocurrency.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.ViewModelFactoryModule
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope

@Module(includes = [ViewModelFactoryModule::class])
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

}