package pl.marekvogt.cryptocurrency.ui.list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope

@Module
interface CryptoCurrencyListModule {

    @Binds
    @FragmentScope
    fun bindCryptoCurrencyMapper(mapper: DefaultCryptoCurrencyRateMapper): CryptoCurrencyRateMapper

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(CryptoCurrencyListViewModel::class)
    fun bindCryptoCurrencyListViewModel(viewModel: CryptoCurrencyListViewModel): ViewModel

}