package pl.marekvogt.cryptocurrency.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pl.marekvogt.cryptocurrency.data.cache.Cached
import pl.marekvogt.cryptocurrency.data.network.CryptoCurrenciesService
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRates
import pl.marekvogt.cryptocurrency.domain.repository.BaseCurrencyRepository
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesCachedRepository
import javax.inject.Inject

class CryptoCurrenciesRestRepository @Inject constructor(
    private val cryptoCurrenciesService: CryptoCurrenciesService,
    private val baseCurrencyRepository: BaseCurrencyRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : CryptoCurrenciesCachedRepository {

    private val cachedCurrencyRates: Cached<CryptoCurrencyRates> = Cached(CryptoCurrencyRates(emptyList()))

    override suspend fun fetchAll(): List<CryptoCurrencyRate> =
        withContext(coroutineDispatcher) {
            val baseCurrency = baseCurrencyRepository.getBaseCurrency()
            cachedCurrencyRates.get(
                freshDataSource = { cryptoCurrenciesService.fetchAll(baseCurrency.symbol) },
                cacheValidityPredicate = { it.rates.isNotEmpty() }
            ).rates
        }

    override fun invalidateCache() {
        cachedCurrencyRates.clearCache()
    }

}