package pl.marekvogt.cryptocurrency.ui.list

import android.content.Context
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.ui.common.formatter.MoneyFormatter
import pl.marekvogt.cryptocurrency.ui.common.extension.getDrawableByIdentifier
import java.util.*

interface CryptoCurrencyRateMapper {
    fun map(currencyRate: CryptoCurrencyRate) : CryptoCurrencyRateViewEntity
}

class DefaultCryptoCurrencyRateMapper(
    private val context: Context,
    private val moneyFormatter: MoneyFormatter,
    private val locale: Locale
) : CryptoCurrencyRateMapper {

    override fun map(currencyRate: CryptoCurrencyRate) =
        CryptoCurrencyRateViewEntity(
            currency = currencyRate.cryptoCurrency,
            price = moneyFormatter.format(currencyRate.price),
            iconRes = resolveCurrencyIconRes(currencyRate)
        )

    private fun resolveCurrencyIconRes(currencyRate: CryptoCurrencyRate) =
        context.getDrawableByIdentifier(currencyRate.cryptoCurrency.symbol.toLowerCase(locale)) ?: R.drawable.unknown
}