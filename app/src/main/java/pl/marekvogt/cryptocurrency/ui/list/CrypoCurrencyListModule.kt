package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import java.util.*


@Module(includes = [CryptoCurrencyListModule.ViewModelProvider::class])
object CryptoCurrencyListModule {

    @Provides
    @FragmentScope
    @JvmStatic
    fun provideCryptoCurrencyMapper(
        context: Context,
        moneyFormatter: MoneyFormatter,
        locale: Locale
    ): CryptoCurrencyRateMapper = DefaultCryptoCurrencyRateMapper(context, moneyFormatter, locale)

    @Provides
    @FragmentScope
    @JvmStatic
    fun provideCryptoCurrencyRateAdapter(): CryptoCurrencyListAdapter = CryptoCurrencyListAdapter()

    @Module
    interface ViewModelProvider {

        @Binds
        @IntoMap
        @FragmentScope
        @ViewModelKey(CryptoCurrencyListViewModel::class)
        fun bindCryptoCurrencyListViewModel(viewModel: CryptoCurrencyListViewModel): ViewModel
    }
}