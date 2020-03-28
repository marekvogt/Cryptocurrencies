package pl.marekvogt.cryptocurrency.ui.list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.ui.common.ViewModelKey

@Module
interface CryptoCurrencyListModule {

    @Binds
    fun bindCryptoCurrencyMapper(mapper: DefaultCryptoCurrencyRateMapper): CryptoCurrencyRateMapper

    @Binds
    @IntoMap
    @ViewModelKey(CryptoCurrencyListViewModel::class)
    fun bindCryptoCurrencyListViewModel(viewModel: CryptoCurrencyListViewModel): ViewModel

}