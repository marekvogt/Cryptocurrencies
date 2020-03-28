package pl.marekvogt.cryptocurrency.domain.repository

import pl.marekvogt.cryptocurrency.domain.model.Currency

interface BaseCurrencyRepository {

    fun getBaseCurrency(): Currency
}