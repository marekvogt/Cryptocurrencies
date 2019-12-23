package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import pl.marekvogt.cryptocurrency.ui.common.extension.getDrawableByName
import pl.marekvogt.cryptocurrency.ui.common.formatter.TrendFormatter
import java.util.*
import javax.inject.Inject

interface CryptoCurrencyRateMapper {
    fun map(currencyRate: CryptoCurrencyRate): CryptoCurrencyRateViewEntity
}

class DefaultCryptoCurrencyRateMapper @Inject constructor(
    private val context: Context,
    private val moneyFormatter: MoneyFormatter,
    private val trendFormatter: TrendFormatter,
    private val locale: Locale
) : CryptoCurrencyRateMapper {

    override fun map(currencyRate: CryptoCurrencyRate) =
        CryptoCurrencyRateViewEntity(
            currency = currencyRate.cryptoCurrency,
            price = moneyFormatter.format(currencyRate.price, fractionDigits = 5),
            iconRes = resolveCurrencyIconRes(currencyRate),
            dayVolume = moneyFormatter.format(currencyRate.dayVolume),
            circulatingSupply = moneyFormatter.format(currencyRate.supply.circulating, currencyRate.cryptoCurrency.symbol),
            totalSupply = moneyFormatter.format(currencyRate.supply.total, currencyRate.cryptoCurrency.symbol),
            maxSupply = currencyRate.supply.maximum?.let { moneyFormatter.format(it, currencyRate.cryptoCurrency.symbol) }
                ?: context.getString(R.string.l_not_provided),
            hourChange = trendFormatter.format(currencyRate.trendHistory.hour),
            dayChange = trendFormatter.format(currencyRate.trendHistory.day),
            weekChange = trendFormatter.format(currencyRate.trendHistory.week)
        )

    private fun resolveCurrencyIconRes(currencyRate: CryptoCurrencyRate) =
        context.getDrawableByName(currencyRate.cryptoCurrency.symbol.toLowerCase(locale)) ?: R.drawable.unknown
}