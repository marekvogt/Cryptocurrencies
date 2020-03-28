package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

val testCurrencyRate: CryptoCurrencyRate =
    CryptoCurrencyRate(
        cryptoCurrency = CryptoCurrency(
            id = "bitcoin",
            name = "Bitcoin",
            symbol = "BTC"
        ),
        price = BigDecimal.valueOf(100),
        dayTrend = Trend(
            percentageChange = BigDecimal.valueOf(0.10),
            direction = TrendDirection.RISING
        ),
        circulatingSupply = BigDecimal.valueOf(100),
        marketCap = BigDecimal.valueOf(150),
        totalVolume = BigDecimal.valueOf(50)
    )