package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesRepository
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import java.util.*


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
    @IntoMap
    @JvmStatic
    @ViewModelKey(CryptoCurrencyListViewModel::class)
    fun provideViewModel(
        cryptoCurrenciesRepository: CryptoCurrenciesRepository,
        cryptoCurrencyRateMapper: CryptoCurrencyRateMapper,
        errorMessageResolver: ErrorMessageResolver
    ): ViewModel = CryptoCurrencyListViewModel(cryptoCurrenciesRepository, cryptoCurrencyRateMapper, errorMessageResolver)
}