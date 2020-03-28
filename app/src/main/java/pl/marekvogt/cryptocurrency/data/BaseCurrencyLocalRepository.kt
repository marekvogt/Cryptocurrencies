package pl.marekvogt.cryptocurrency.data

import pl.marekvogt.cryptocurrency.domain.model.Currency
import pl.marekvogt.cryptocurrency.domain.repository.BaseCurrencyRepository
import javax.inject.Inject

class BaseCurrencyLocalRepository @Inject constructor() : BaseCurrencyRepository {

    override fun getBaseCurrency(): Currency = Currency("USD")

}