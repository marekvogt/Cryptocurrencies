package pl.marekvogt.cryptocurrency.ui.list

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrency
import java.io.Serializable

data class CryptoCurrencyListViewState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val cryptoRates: List<CryptoCurrencyRateViewEntity> = emptyList()
)

data class CryptoCurrencyRateViewEntity(
    val currency: CryptoCurrency,
    val price: String,
    val iconRes: Int,
    val dayVolume: String,
    val circulatingSupply: String,
    val dayChange: String
): Serializable