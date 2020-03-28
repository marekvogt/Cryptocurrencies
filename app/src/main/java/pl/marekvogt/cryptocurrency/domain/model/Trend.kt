package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

data class Trend(
    val percentageChange: BigDecimal,
    val direction: TrendDirection
)

enum class TrendDirection {
    RISING, FALLING, STANDING
}