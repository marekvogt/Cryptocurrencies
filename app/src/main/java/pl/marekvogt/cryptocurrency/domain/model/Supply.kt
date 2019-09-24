package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

data class Supply(
    val circulating: BigDecimal,
    val maximum: BigDecimal?,
    val total : BigDecimal
)