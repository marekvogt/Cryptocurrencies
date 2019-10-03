package pl.marekvogt.cryptocurrency.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.BaseViewModel
import pl.marekvogt.cryptocurrency.ui.common.view.LabelValue
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import javax.inject.Inject

class CryptoCurrencyDetailsViewModel @Inject constructor(
    private val cryptoCurrencyDetailsMapper: CryptoCurrencyDetailsMapper
) : BaseViewModel() {

    private val viewState: LiveData<List<LabelValue>> = MutableLiveData()

    fun getViewState(cryptoCurrencyRateViewEntity: CryptoCurrencyRateViewEntity): LiveData<List<LabelValue>> {
        viewState.updateValue(cryptoCurrencyDetailsMapper.map(cryptoCurrencyRateViewEntity))
        return viewState
    }
}