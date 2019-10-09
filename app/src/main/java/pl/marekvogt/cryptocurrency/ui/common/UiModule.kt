package pl.marekvogt.cryptocurrency.ui.common

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.marekvogt.cryptocurrency.ui.common.error.DefaultErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.formatter.CryptoCurrencyPriceFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.DefaultTrendFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.TrendFormatter

@Module
object UiModule {

    @Provides
    @JvmStatic
    fun provideMoneyFormatter(): MoneyFormatter = CryptoCurrencyPriceFormatter()

    @Provides
    @JvmStatic
    fun provideErrorMessageResolver(
        context: Context
    ): ErrorMessageResolver = DefaultErrorMessageResolver(context)

    @Provides
    @JvmStatic
    fun provideTrendFormatter(): TrendFormatter = DefaultTrendFormatter()
}