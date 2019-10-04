package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import pl.marekvogt.cryptocurrency.di.ViewModelKey
import pl.marekvogt.cryptocurrency.di.ViewModelFactoryModule
import pl.marekvogt.cryptocurrency.di.scope.FragmentScope
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCacheableRepository
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import java.util.*


@Module(includes = [ViewModelFactoryModule::class])
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
    @IntoMap
    @ViewModelKey(CryptoCurrencyListViewModel::class)
    fun provideCryptoCurrencyListViewModel(
        cryptoCurrenciesRepository: CryptoCurrenciesCacheableRepository,
        cryptoCurrencyRateMapper: CryptoCurrencyRateMapper,
        errorMessageResolver: ErrorMessageResolver
    ): ViewModel = CryptoCurrencyListViewModel(
        cryptoCurrenciesRepository,
        cryptoCurrencyRateMapper,
        errorMessageResolver
    )
}