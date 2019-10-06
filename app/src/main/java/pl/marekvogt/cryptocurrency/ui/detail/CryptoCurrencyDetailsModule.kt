package pl.marekvogt.cryptocurrency.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope

@Module(includes = [CryptoCurrencyDetailsModule.ViewModelProvider::class])
object CryptoCurrencyDetailsModule {

    @Provides
    @FragmentScope
    @JvmStatic
    fun provideCryptoCurrencyDetailsMapper(
        context: Context
    ): CryptoCurrencyDetailsMapper = DefaultCryptoCurrencyDetailsMapper(context)

    @Module
    interface ViewModelProvider {

        @Binds
        @IntoMap
        @FragmentScope
        @ViewModelKey(CryptoCurrencyDetailsViewModel::class)
        fun bindCryptoCurrencyDetailsViewModel(viewModel: CryptoCurrencyDetailsViewModel): ViewModel
    }
}