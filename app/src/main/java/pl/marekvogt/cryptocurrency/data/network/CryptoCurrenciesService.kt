package pl.marekvogt.cryptocurrency.data.network

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRates
import retrofit2.http.GET

interface CryptoCurrenciesService {

    @GET("v2/ticker")
    suspend fun fetchAll(): CryptoCurrencyRates
}