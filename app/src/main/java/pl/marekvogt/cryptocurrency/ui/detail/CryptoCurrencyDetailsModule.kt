package pl.marekvogt.cryptocurrency.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import javax.inject.Named

@Module
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
    @Named("ViewModelFactory.Details")
    fun provideCryptoCurrencyDetailsViewModelFactory(
        currencyDetailsViewModel: CryptoCurrencyDetailsViewModel
    ): ViewModelProvider.Factory = CryptoCurrencyDetailsViewModelFactory(currencyDetailsViewModel)
}