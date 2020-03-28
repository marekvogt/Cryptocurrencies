package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

data class CryptoCurrencyRate(
    val cryptoCurrency: CryptoCurrency,
    val price: BigDecimal,
    val circulatingSupply: BigDecimal,
    val marketCap: BigDecimal,
    val totalVolume: BigDecimal,
    val dayTrend: Trend
)