package pl.marekvogt.cryptocurrency.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.BaseViewModel
import pl.marekvogt.cryptocurrency.ui.common.view.LabelValue
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import javax.inject.Inject

@HiltViewModel
class CryptoCurrencyDetailsViewModel @Inject constructor(
    private val cryptoCurrencyDetailsMapper: CryptoCurrencyDetailsMapper
) : BaseViewModel() {

    val viewState: LiveData<List<LabelValue>> = MutableLiveData(emptyList())

    fun setupCurrencyDetails(cryptoCurrencyRateViewEntity: CryptoCurrencyRateViewEntity) {
        viewState.updateValue(cryptoCurrencyDetailsMapper.map(cryptoCurrencyRateViewEntity))
    }
}