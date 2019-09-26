package pl.marekvogt.cryptocurrency.domain.model

import java.io.Serializable

data class CryptoCurrency(
    val id: Int,
    val name: String,
    val symbol: String
): Serializable