package pl.marekvogt.cryptocurrency.domain.model

data class CryptoCurrencyRate(
    val cryptoCurrency: CryptoCurrency,
    val price: Money
)