package pl.marekvogt.cryptocurrency.domain.repository

import pl.marekvogt.cryptocurrency.domain.cache.Cacheable
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate

interface CryptoCurrenciesRepository {

    suspend fun fetchAll(): List<CryptoCurrencyRate>
}

interface CryptoCurrenciesCachedRepository : CryptoCurrenciesRepository, Cacheable