package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import java.util.*
import javax.inject.Named


@Module
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

    @Provides
    @FragmentScope
    @JvmStatic
    @Named("ViewModelFactory.List")
    fun provideCryptoCurrencyListViewModelFactory(
        cryptoCurrencyListViewModel: CryptoCurrencyListViewModel
    ): ViewModelProvider.Factory = CryptoCurrencyListViewModelFactory(cryptoCurrencyListViewModel)
}