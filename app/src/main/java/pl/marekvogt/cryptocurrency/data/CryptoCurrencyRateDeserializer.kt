package pl.marekvogt.cryptocurrency.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import pl.marekvogt.cryptocurrency.data.extension.getBigDecimal
import pl.marekvogt.cryptocurrency.data.extension.getString
import pl.marekvogt.cryptocurrency.domain.model.*
import java.lang.Exception
import java.lang.reflect.Type
import java.math.BigDecimal

class CryptoCurrencyRatesDeserializer : JsonDeserializer<CryptoCurrencyRates> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CryptoCurrencyRates {
        val elements = json?.asJsonArray?.mapNotNull {
            val currencyRateData = it.asJsonObject
            try {
                CryptoCurrencyRate(
                    cryptoCurrency = deserializeCurrency(currencyRateData),
                    price = currencyRateData.getBigDecimal("current_price"),
                    totalVolume = currencyRateData.getBigDecimal("total_volume"),
                    marketCap = currencyRateData.getBigDecimal("market_cap"),
                    circulatingSupply = currencyRateData.getBigDecimal("circulating_supply"),
                    dayTrend = deserializeDayTrend(currencyRateData)
                )
            } catch (ex: Exception) {
                null
            }
        }?.toList()
        return CryptoCurrencyRates(elements ?: emptyList())
    }

    private fun deserializeCurrency(currencyRateData: JsonObject): CryptoCurrency {
        return CryptoCurrency(
            id = currencyRateData.getString("id"),
            symbol = currencyRateData.getString("symbol"),
            name = currencyRateData.getString("name")
        )
    }

    private fun deserializeDayTrend(currencyRateData: JsonObject): Trend {
        val dayPercentageChange = currencyRateData.getBigDecimal("price_change_percentage_24h")
        return Trend(
            percentageChange = dayPercentageChange.abs(),
            direction = resolveTrendDirection(dayPercentageChange)
        )
    }

    private fun resolveTrendDirection(trendValue: BigDecimal) = when (trendValue.signum()) {
        1 -> TrendDirection.RISING
        -1 -> TrendDirection.FALLING
        else -> TrendDirection.STANDING
    }
}