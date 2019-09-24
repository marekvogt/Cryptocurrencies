package pl.marekvogt.cryptocurrency.domain.model

data class CryptoCurrencyRate(
    val cryptoCurrency: CryptoCurrency,
    val price: Money,
    val supply: Supply,
    val marketCap: Money,
    val dayVolume: Money,
    val trendHistory: TrendHistory
)