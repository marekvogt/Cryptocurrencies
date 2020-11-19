package pl.marekvogt.cryptocurrency.data.network

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRates
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCurrenciesService {

    @GET("api/v3/coins/markets?order=market_cap_desc&per_page=100&page=1&sparkline=false&vs_currency=USD")
    suspend fun fetchAll(@Query("vs_currency") baseCurrencySymbol: String): CryptoCurrencyRates
}