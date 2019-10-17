package pl.marekvogt.cryptocurrency.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.marekvogt.cryptocurrency.ui.detail.mapper.FakeCryptoCurrencyDetailsMapper
import pl.marekvogt.cryptocurrency.ui.list.testCurrencyRateViewEntity

class CryptoCurrencyDetailsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CryptoCurrencyDetailsViewModel
    private lateinit var cryptoCurrencyRateDetailsMapper: FakeCryptoCurrencyDetailsMapper

    @Before
    fun beforeEach() {
        cryptoCurrencyRateDetailsMapper = FakeCryptoCurrencyDetailsMapper()
        viewModel = CryptoCurrencyDetailsViewModel(cryptoCurrencyRateDetailsMapper)
    }

    @Test
    fun `should emit transformed data when currency details is passed`() {
        viewModel.setupCurrencyDetails(testCurrencyRateViewEntity)

        viewModel.viewState.value shouldEqual testLabelValueData
    }

    @Test
    fun `should emit empty data when currency details is not passed`() {
        viewModel.viewState.value shouldEqual emptyList()
    }
}