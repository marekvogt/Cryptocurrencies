package pl.marekvogt.cryptocurrency.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCachedRepository
import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.BaseViewModel
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.Event
import javax.inject.Inject

class CryptoCurrencyListViewModel @Inject constructor(
    private val cryptoCurrenciesRepository: CryptoCurrenciesCachedRepository,
    private val cryptoCurrencyRateMapper: CryptoCurrencyRateMapper,
    private val errorMessageResolver: ErrorMessageResolver
) : BaseViewModel() {

    val startLoadingAnimationEvent: LiveData<Event<Unit>> = MutableLiveData()
    val stopLoadingAnimationEvent: LiveData<Event<Unit>> = MutableLiveData()
    val errorMessageEvent: LiveData<Event<String>> = MutableLiveData()

    val viewState: LiveData<CryptoCurrencyListViewState> = MutableLiveData<CryptoCurrencyListViewState>().apply {
        value = CryptoCurrencyListViewState(isLoading = true)
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val errorMessage = errorMessageResolver.resolve(throwable)
        startLoadingAnimationEvent.updateValue(Event(Unit))
        errorMessageEvent.updateValue(Event(errorMessage))
    }

    fun loadCryptoCurrencyRates() {
        viewModelScope.launch(exceptionHandler) {
            val cryptoRates = cryptoCurrenciesRepository.fetchAll()
            viewState.updateValue(CryptoCurrencyListViewState(cryptoRates = cryptoRates.toViewEntities()))
            stopLoadingAnimationEvent.updateValue(Event(Unit))
        }
    }

    fun refreshCryptoCurrencyRates() {
        viewState.updateValue(CryptoCurrencyListViewState(isRefreshing = true))
        cryptoCurrenciesRepository.invalidateCache()
        loadCryptoCurrencyRates()
    }

    fun startLoadingAnimationIfNeeded() {
        if (viewState.value?.isLoading == true) {
            startLoadingAnimationEvent.updateValue(Event(Unit))
        }
    }

    fun stopLoadingAnimationIfNeeded() {
        if (viewState.value?.isLoading == true) {
            stopLoadingAnimationEvent.updateValue(Event(Unit))
        }
    }

    private fun List<CryptoCurrencyRate>.toViewEntities() = map(cryptoCurrencyRateMapper::map)

}