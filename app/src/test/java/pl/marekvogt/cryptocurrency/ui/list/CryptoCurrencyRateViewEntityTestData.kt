package pl.marekvogt.cryptocurrency.ui.list

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrency

val testCurrencyRateViewEntity: CryptoCurrencyRateViewEntity =
    CryptoCurrencyRateViewEntity(
        currency = CryptoCurrency(
            id = "bitcoin",
            name = "Bitcoin",
            symbol = "BTC"
        ),
        dayVolume = "0",
        price = "0",
        circulatingSupply = "100",
        iconRes = 1,
        dayChange = "24"
    )