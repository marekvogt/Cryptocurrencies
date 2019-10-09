package pl.marekvogt.cryptocurrency.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import pl.marekvogt.cryptocurrency.data.extension.getBigDecimal
import pl.marekvogt.cryptocurrency.data.extension.getBigDecimalOrNull
import pl.marekvogt.cryptocurrency.data.extension.getInt
import pl.marekvogt.cryptocurrency.data.extension.getString
import pl.marekvogt.cryptocurrency.domain.model.*
import java.lang.reflect.Type
import java.math.BigDecimal

class CryptoCurrencyRatesDeserializer : JsonDeserializer<CryptoCurrencyRates> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CryptoCurrencyRates {
        val data = json!!.asJsonObject.get("data").asJsonObject
        val elements = data.keySet().map {
            val currencyRateData = data.get(it).asJsonObject
            CryptoCurrencyRate(
                cryptoCurrency = deserializeCurrency(currencyRateData),
                price = deserializePrice(currencyRateData),
                dayVolume = deserializeDayVolume(currencyRateData),
                marketCap = deserializeMarketCap(currencyRateData),
                supply = deserializeSupply(currencyRateData),
                trendHistory = deserializeTrendHistory(currencyRateData)
            )
        }.toList()
        return CryptoCurrencyRates(elements)
    }

    private fun deserializePrice(currencyRateData: JsonObject): Money {
        val quotesData = currencyRateData.get("quotes").asJsonObject
        val currencySymbol = quotesData.keySet().first()
        return Money(
            value = quotesData.get(currencySymbol).asJsonObject.getBigDecimal("price"),
            currencySymbol = currencySymbol
        )
    }

    private fun deserializeDayVolume(currencyRateData: JsonObject): Money {
        val quotesData = currencyRateData.get("quotes").asJsonObject
        val currencySymbol = quotesData.keySet().first()
        return Money(
            value = quotesData.get(currencySymbol).asJsonObject.getBigDecimal("volume_24h"),
            currencySymbol = currencySymbol
        )
    }

    private fun deserializeMarketCap(currencyRateData: JsonObject): Money {
        val quotesData = currencyRateData.get("quotes").asJsonObject
        val currencySymbol = quotesData.keySet().first()
        return Money(
            value = quotesData.get(currencySymbol).asJsonObject.getBigDecimal("market_cap"),
            currencySymbol = currencySymbol
        )
    }

    private fun deserializeSupply(currencyRateData: JsonObject): Supply {
        return Supply(
            circulating = currencyRateData.getBigDecimal("circulating_supply"),
            maximum = currencyRateData.getBigDecimalOrNull("max_supply"),
            total = currencyRateData.getBigDecimal("total_supply")
        )
    }

    private fun deserializeTrendHistory(currencyRateData: JsonObject): TrendHistory {
        val quotesData = currencyRateData.get("quotes").asJsonObject
        val currencySymbol = quotesData.keySet().first()
        val quoteData = quotesData.get(currencySymbol).asJsonObject
        val hourPercentageChange = quoteData.getBigDecimal("percent_change_1h")
        val dayPercentageChange = quoteData.getBigDecimal("percent_change_24h")
        val weekPercentageChange = quoteData.getBigDecimal("percent_change_7d")
        return TrendHistory(
            hour = Trend(
                percentageChange = hourPercentageChange.abs(),
                direction = resolveTrendDirection(hourPercentageChange)
            ),
            day = Trend(
                percentageChange = dayPercentageChange.abs(),
                direction = resolveTrendDirection(dayPercentageChange)
            ),
            week = Trend(
                percentageChange = weekPercentageChange.abs(),
                direction = resolveTrendDirection(weekPercentageChange)
            )

        )
    }

    private fun resolveTrendDirection(trendValue: BigDecimal) = when (trendValue.signum()){
        1 -> TrendDirection.RISING
        -1 -> TrendDirection.FALLING
        else -> TrendDirection.STANDING
    }

    private fun deserializeCurrency(currencyRateData: JsonObject): CryptoCurrency {
        return CryptoCurrency(
            id = currencyRateData.getInt("id"),
            symbol = currencyRateData.getString("symbol"),
            name = currencyRateData.getString("name")
        )
    }

}