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
import pl.marekvogt.cryptocurrency.ui.common.formatter.TrendFormatter
import java.util.*


@Module(includes = [CryptoCurrencyListModule.ViewModelProvider::class])
object CryptoCurrencyListModule {

    @Provides
    @FragmentScope
    @JvmStatic
    fun provideCryptoCurrencyMapper(
        context: Context,
        moneyFormatter: MoneyFormatter,
        trendFormatter: TrendFormatter,
        locale: Locale
    ): CryptoCurrencyRateMapper = DefaultCryptoCurrencyRateMapper(
        context,
        moneyFormatter,
        trendFormatter,
        locale
    )

    @Module
    interface ViewModelProvider {

        @Binds
        @IntoMap
        @FragmentScope
        @ViewModelKey(CryptoCurrencyListViewModel::class)
        fun bindCryptoCurrencyListViewModel(viewModel: CryptoCurrencyListViewModel): ViewModel
    }
}