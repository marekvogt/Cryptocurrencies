package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

data class Money(
    val value: BigDecimal,
    val currencySymbol: String
)