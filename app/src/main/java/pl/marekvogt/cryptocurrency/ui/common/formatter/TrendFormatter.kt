package pl.marekvogt.cryptocurrency.ui.common.formatter

import pl.marekvogt.cryptocurrency.domain.model.Trend
import pl.marekvogt.cryptocurrency.domain.model.TrendDirection
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

interface TrendFormatter {

    fun format(trend: Trend): String
}

class DefaultTrendFormatter : TrendFormatter {

    private val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
        roundingMode = RoundingMode.DOWN
    }

    override fun format(trend: Trend): String {
        val formattedValue = numberFormat.format(trend.percentageChange)
        return "${trend.formattedDirection}$formattedValue%"
    }

    private val Trend.formattedDirection
        get() = when (direction) {
            TrendDirection.STANDING -> ""
            TrendDirection.RISING -> "+"
            TrendDirection.FALLING -> "-"
        }
}