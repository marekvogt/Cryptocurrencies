package pl.marekvogt.cryptocurrency.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CryptoCurrencyListViewModelFactory(
    private val cryptoCurrencyListViewModel: CryptoCurrencyListViewModel
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == CryptoCurrencyListViewModel::class.java) { "Unknown ViewModel class" }
        return cryptoCurrencyListViewModel as T
    }
}