package pl.marekvogt.cryptocurrency.ui.common.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import pl.marekvogt.cryptocurrency.ui.common.lifecycle.Event

class NonNullMediatorLiveData<T> : MediatorLiveData<T>() {
    fun observe(owner: LifecycleOwner, observer: (t: T) -> Unit) {
        this.observe(owner, Observer {
            it?.let(observer)
        })
    }
}

fun <T> LiveData<T>.nonNull(): NonNullMediatorLiveData<T> {
    val mediator: NonNullMediatorLiveData<T> = NonNullMediatorLiveData()
    mediator.addSource(this) { it?.let { mediator.value = it } }
    return mediator
}

fun <T> LiveData<Event<T>>.observeEvent(lifecycleOwner: LifecycleOwner, observer: (t: T) -> Unit) {
    observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { value ->
            observer(value)
        }
    })
}