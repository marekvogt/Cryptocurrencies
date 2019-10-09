package pl.marekvogt.cryptocurrency.ui.common.formatter

import pl.marekvogt.cryptocurrency.domain.model.Money
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

interface MoneyFormatter {
    fun format(money: Money): String

    fun format(money: Money, fractionDigits: Int): String

    fun format(amount: BigDecimal, currencySymbol: String): String

    fun format(amount: BigDecimal, currencySymbol: String, fractionDigits: Int): String
}

private const val DEFAULT_FRACTION_DIGITS_NUMBER = 0

class CryptoCurrencyPriceFormatter : MoneyFormatter {

    private val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        setFractionDigits(5)
        roundingMode = RoundingMode.DOWN
    }

    override fun format(money: Money): String = format(money, DEFAULT_FRACTION_DIGITS_NUMBER)


    override fun format(money: Money, fractionDigits: Int): String = format(money.value, money.currencySymbol, fractionDigits)

    override fun format(amount: BigDecimal, currencySymbol: String) = format(amount, currencySymbol, DEFAULT_FRACTION_DIGITS_NUMBER)

    override fun format(amount: BigDecimal, currencySymbol: String, fractionDigits: Int): String {
        numberFormat.setFractionDigits(fractionDigits)
        return "${numberFormat.format(amount)} $currencySymbol"
    }

    private fun NumberFormat.setFractionDigits(fractionDigits: Int) {
        minimumFractionDigits = fractionDigits
        maximumFractionDigits = fractionDigits
    }
}