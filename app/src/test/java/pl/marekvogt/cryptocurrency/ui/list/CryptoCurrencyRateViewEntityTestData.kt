package pl.marekvogt.cryptocurrency.ui.list

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrency
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity

val testCurrencyRateViewEntity: CryptoCurrencyRateViewEntity =
    CryptoCurrencyRateViewEntity(
        currency = CryptoCurrency(
            id = 0,
            name = "Bitcoin",
            symbol = "BTC"
        ),
        dayVolume = "0",
        price = "0",
        circulatingSupply = "100",
        iconRes = 1,
        dayChange = "24",
        hourChange = "1",
        weekChange = "7",
        maxSupply = "50",
        totalSupply = "75"
    )