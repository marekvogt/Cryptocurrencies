package pl.marekvogt.cryptocurrency.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CryptoCurrencyDetailsViewModelFactory @Inject constructor(
    private val currencyDetailsViewModel: CryptoCurrencyDetailsViewModel
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == CryptoCurrencyDetailsViewModel::class.java) { "Unknown ViewModel class" }
        return currencyDetailsViewModel as T
    }
}