package pl.marekvogt.cryptocurrency.ui.common

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pl.marekvogt.cryptocurrency.ui.common.error.DefaultErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.formatter.CryptoCurrencyPriceFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.DefaultTrendFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import pl.marekvogt.cryptocurrency.ui.common.formatter.TrendFormatter

@Module
@InstallIn(ApplicationComponent::class)
interface UiModule {

    @Binds
    fun bindMoneyFormatter(priceFormatter: CryptoCurrencyPriceFormatter): MoneyFormatter

    @Binds
    fun bindErrorMessageResolver(errorMessageResolver: DefaultErrorMessageResolver): ErrorMessageResolver

    @Binds
    fun bindTrendFormatter(trendFormatter: DefaultTrendFormatter): TrendFormatter
}