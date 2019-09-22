package pl.marekvogt.cryptocurrency.ui.common.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected fun <T> LiveData<T>.updateValue(state: T?) {
        (this as? MutableLiveData<T>)?.apply {
            value = state
        }
    }
}