package pl.marekvogt.cryptocurrency.domain.repository

import pl.marekvogt.cryptocurrency.domain.model.Currency

class FakeBaseCurrencyRepository : BaseCurrencyRepository {
    override fun getBaseCurrency(): Currency = Currency("USD")
}