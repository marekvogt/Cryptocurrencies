package pl.marekvogt.cryptocurrency.ui.list

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrency
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.Event
import java.io.Serializable

class CryptoCurrencyListViewState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val cryptoRates: List<CryptoCurrencyRateViewEntity> = emptyList(),
    val errorMessageEvent: Event<String>? = null
)

data class CryptoCurrencyRateViewEntity(
    val currency: CryptoCurrency,
    val price: String,
    val iconRes: Int
): Serializable