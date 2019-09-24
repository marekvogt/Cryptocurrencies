package pl.marekvogt.cryptocurrency.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesRepository
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.BaseViewModel
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.Event
import javax.inject.Inject

class CryptoCurrencyListViewModel @Inject constructor(
    private val cryptoCurrenciesRepository: CryptoCurrenciesRepository,
    private val cryptoCurrencyRateMapper: CryptoCurrencyRateMapper,
    private val errorMessageResolver: ErrorMessageResolver
) : BaseViewModel() {

    private lateinit var viewState: LiveData<CryptoCurrencyListViewState>

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val errorMessage = errorMessageResolver.resolve(throwable)
        viewState.updateValue(CryptoCurrencyListViewState(errorMessageEvent = Event(errorMessage)))
    }

    fun getViewState(): LiveData<CryptoCurrencyListViewState> {
        if (!::viewState.isInitialized) {
            viewState = MutableLiveData()
            loadCryptoCurrencyRates()
        }
        return viewState
    }

    private fun loadCryptoCurrencyRates() {
        viewState.updateValue(CryptoCurrencyListViewState(isLoading = true))
        fetchCurrencyRates()
    }

    fun refreshCryptoCurrencyRates() {
        viewState.updateValue(CryptoCurrencyListViewState(isRefreshing = true))
        fetchCurrencyRates()
    }

    private fun fetchCurrencyRates() {
        viewModelScope.launch(exceptionHandler) {
            val cryptoRates = cryptoCurrenciesRepository.fetchAll()
            viewState.updateValue(CryptoCurrencyListViewState(cryptoRates = cryptoRates.toViewEntities()))
        }
    }

    private fun List<CryptoCurrencyRate>.toViewEntities() = map(cryptoCurrencyRateMapper::map)

}