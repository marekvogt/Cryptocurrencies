package pl.marekvogt.cryptocurrency.ui.detail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope

@Module
interface CryptoCurrencyDetailsModule {

    @Binds
    @FragmentScope
    fun bindCryptoCurrencyDetailsMapper(mapper: DefaultCryptoCurrencyDetailsMapper): CryptoCurrencyDetailsMapper

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(CryptoCurrencyDetailsViewModel::class)
    fun bindCryptoCurrencyDetailsViewModel(viewModel: CryptoCurrencyDetailsViewModel): ViewModel
}