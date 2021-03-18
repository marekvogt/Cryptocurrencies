package pl.marekvogt.cryptocurrency.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.marekvogt.cryptocurrency.domain.model.testCurrencyRate
import pl.marekvogt.cryptocurrency.domain.repository.FakeBaseCurrencyRepository
import pl.marekvogt.cryptocurrency.domain.repository.FakeCryptoCurrenciesRepository
import pl.marekvogt.cryptocurrency.ui.common.FakeErrorMessageResolver
import pl.marekvogt.cryptocurrency.ui.common.errorMessage
import pl.marekvogt.cryptocurrency.ui.list.mapper.FakeCryptoCurrencyRateMapper
import pl.marekvogt.cryptocurrency.util.MainCoroutineRule

@ExperimentalCoroutinesApi
class CryptoCurrencyListViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CryptoCurrencyListViewModel
    private lateinit var cryptoCurrenciesRepository: FakeCryptoCurrenciesRepository
    private lateinit var baseCurrencyRepository: FakeBaseCurrencyRepository
    private lateinit var cryptoCurrencyRateMapper: FakeCryptoCurrencyRateMapper
    private lateinit var errorMessageResolver: FakeErrorMessageResolver

    @Before
    fun beforeEach() {
        cryptoCurrenciesRepository = FakeCryptoCurrenciesRepository()
        baseCurrencyRepository = FakeBaseCurrencyRepository()
        cryptoCurrencyRateMapper = FakeCryptoCurrencyRateMapper()
        errorMessageResolver = FakeErrorMessageResolver()
        viewModel = CryptoCurrencyListViewModel(cryptoCurrenciesRepository, cryptoCurrencyRateMapper, baseCurrencyRepository, errorMessageResolver)
    }

    @Test
    fun `should emit loading state when fetching currency rates`() {
        mainCoroutineRule.pauseDispatcher()
        viewModel.loadCryptoCurrencyRates()
        viewModel.viewState.value shouldEqual loadingState
    }

    @Test
    fun `should emit refreshing state when refreshing currency rates`() {
        mainCoroutineRule.pauseDispatcher()
        viewModel.refreshCryptoCurrencyRates()
        viewModel.viewState.value shouldEqual refreshingState
    }

    @Test
    fun `should emit loaded currency rates`() {
        cryptoCurrenciesRepository.addRates(testCurrencyRate)

        viewModel.loadCryptoCurrencyRates()
        viewModel.viewState.value shouldEqual loadedState
    }

    @Test
    fun `should emit error when fetching currency rates fails`() {
        cryptoCurrenciesRepository.shouldReturnError = true

        viewModel.loadCryptoCurrencyRates()
        viewModel.errorMessageEvent.value?.getContentIfNotHandled() shouldEqual errorMessage
    }
}