package pl.marekvogt.cryptocurrency.domain.repository

import androidx.annotation.VisibleForTesting
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate

class FakeCryptoCurrenciesRepository : CryptoCurrenciesCacheableRepository {

    private val cryptoCurrencyRates: MutableList<CryptoCurrencyRate> = mutableListOf()

    var shouldReturnError = false

    override suspend fun fetchAll(): List<CryptoCurrencyRate> {
        if (shouldReturnError) {
            throw Exception()
        } else {
            return cryptoCurrencyRates
        }
    }

    override fun invalidateCache() {
        cryptoCurrencyRates.clear()
    }

    @VisibleForTesting
    fun addRates(vararg cryptoRates: CryptoCurrencyRate) {
        cryptoCurrencyRates.addAll(cryptoRates)
    }
}