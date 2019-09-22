package pl.marekvogt.cryptocurrency.ui.common.formatter

import pl.marekvogt.cryptocurrency.domain.model.Money
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

interface MoneyFormatter {
    fun format(money: Money): String
}

class CryptoCurrencyPriceFormatter : MoneyFormatter {

    private val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 5
        maximumFractionDigits = 5
        roundingMode = RoundingMode.DOWN
    }

    override fun format(money: Money): String =
        "${numberFormat.format(money.value)} ${money.currencySymbol}"

}