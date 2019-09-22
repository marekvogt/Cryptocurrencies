package pl.marekvogt.cryptocurrency.ui.common

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.marekvogt.cryptocurrency.ui.common.error.DefaultErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.formatter.CryptoCurrencyPriceFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter

@Module
class UiModule {

    @Provides
    fun provideMoneyFormatter(): MoneyFormatter = CryptoCurrencyPriceFormatter()

    @Provides
    fun provideErrorMessageResolver(
        context: Context
    ): ErrorMessageResolver = DefaultErrorMessageResolver(context)
}