package pl.marekvogt.cryptocurrency.domain.model

import java.math.BigDecimal

val testCurrencyRate: CryptoCurrencyRate =
    CryptoCurrencyRate(
        cryptoCurrency = CryptoCurrency(
            id = 0,
            name = "Bitcoin",
            symbol = "BTC"
        ),
        price = Money(
            value = BigDecimal.valueOf(100),
            currencySymbol = "USD"
        ),
        trendHistory = TrendHistory(
            week = Trend(
                percentageChange = BigDecimal.valueOf(0.10),
                direction = TrendDirection.RISING
            ),
            day = Trend(
                percentageChange = BigDecimal.valueOf(0.10),
                direction = TrendDirection.RISING
            ),
            hour = Trend(
                percentageChange = BigDecimal.valueOf(0.10),
                direction = TrendDirection.RISING
            )
        ),
        supply = Supply(
            circulating = BigDecimal.valueOf(100),
            total = BigDecimal.valueOf(100),
            maximum = BigDecimal.valueOf(100)
        ),
        marketCap = Money(
            value = BigDecimal.valueOf(150),
            currencySymbol = "USD"
        ),
        dayVolume = Money(
            value = BigDecimal.valueOf(50),
            currencySymbol = "USD"
        )
    )