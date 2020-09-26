package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.model.Currency
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import pl.marekvogt.cryptocurrency.ui.common.extension.getDrawableByName
import pl.marekvogt.cryptocurrency.ui.common.formatter.TrendFormatter
import java.util.*
import javax.inject.Inject

interface CryptoCurrencyRateMapper {
    fun map(currencyRate: CryptoCurrencyRate, baseCurrency: Currency): CryptoCurrencyRateViewEntity
}

class DefaultCryptoCurrencyRateMapper @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moneyFormatter: MoneyFormatter,
    private val trendFormatter: TrendFormatter,
    private val locale: Locale
) : CryptoCurrencyRateMapper {

    override fun map(currencyRate: CryptoCurrencyRate, baseCurrency: Currency) =
        CryptoCurrencyRateViewEntity(
            currency = currencyRate.cryptoCurrency,
            price = moneyFormatter.format(currencyRate.price, baseCurrency.symbol, fractionDigits = 5),
            iconRes = resolveCurrencyIconRes(currencyRate),
            dayVolume = moneyFormatter.format(currencyRate.totalVolume, baseCurrency.symbol),
            circulatingSupply = moneyFormatter.format(currencyRate.circulatingSupply, currencyRate.cryptoCurrency.symbol),
            dayChange = trendFormatter.format(currencyRate.dayTrend)
        )

    private fun resolveCurrencyIconRes(currencyRate: CryptoCurrencyRate) =
        context.getDrawableByName(currencyRate.cryptoCurrency.symbol.toLowerCase(locale)) ?: R.drawable.unknown
}