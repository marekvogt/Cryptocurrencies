package pl.marekvogt.cryptocurrency.ui.list

val loadingState: CryptoCurrencyListViewState = CryptoCurrencyListViewState(
    isLoading = true,
    isRefreshing = false,
    cryptoRates = emptyList()
)

val refreshingState: CryptoCurrencyListViewState = CryptoCurrencyListViewState(
    isLoading = false,
    isRefreshing = true,
    cryptoRates = emptyList()
)

val loadedState: CryptoCurrencyListViewState = CryptoCurrencyListViewState(
    isLoading = false,
    isRefreshing = false,
    cryptoRates = listOf(testCurrencyRateViewEntity)
)