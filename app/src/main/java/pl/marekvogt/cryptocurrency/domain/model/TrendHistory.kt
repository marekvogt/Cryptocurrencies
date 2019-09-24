package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

data class TrendHistory(
    val hour: Trend,
    val day: Trend,
    val week: Trend
)

data class Trend(
    val percentageChange: BigDecimal,
    val direction: TrendDirection
)

enum class TrendDirection {
    RISING, FALLING, STANDING
}