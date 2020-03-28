package pl.marekvogt.cryptocurrency.ui.detail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.ui.common.ViewModelKey

@Module
interface CryptoCurrencyDetailsModule {

    @Binds
    fun bindCryptoCurrencyDetailsMapper(mapper: DefaultCryptoCurrencyDetailsMapper): CryptoCurrencyDetailsMapper

    @Binds
    @IntoMap
    @ViewModelKey(CryptoCurrencyDetailsViewModel::class)
    fun bindCryptoCurrencyDetailsViewModel(viewModel: CryptoCurrencyDetailsViewModel): ViewModel
}