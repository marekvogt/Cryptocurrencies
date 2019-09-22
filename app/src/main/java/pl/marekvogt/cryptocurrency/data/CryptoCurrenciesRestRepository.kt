package pl.marekvogt.cryptocurrency.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.marekvogt.cryptocurrency.data.network.CryptoCurrenciesService
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.repository.CryptoCurrenciesRepository

class CryptoCurrenciesRestRepository(
    private val cryptoCurrenciesService: CryptoCurrenciesService
) : CryptoCurrenciesRepository {

    override suspend fun fetchAll(): List<CryptoCurrencyRate> =
        withContext(Dispatchers.IO) {
            cryptoCurrenciesService.fetchAll().rates
        }

}