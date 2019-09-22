package pl.marekvogt.cryptocurrency.data

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrency
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRates
import pl.marekvogt.cryptocurrency.domain.model.Money
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
                price = deserializePrice(currencyRateData)
            )
        }.toList()
        return CryptoCurrencyRates(elements)
    }

    private fun deserializePrice(currencyRateData: JsonObject): Money {
        val quotesData = currencyRateData.get("quotes").asJsonObject
        val currencySymbol = quotesData.keySet().first()
        return Money(
            value = BigDecimal(quotesData.get(currencySymbol).asJsonObject.get("price").asString),
            currencySymbol = currencySymbol
        )
    }

    private fun deserializeCurrency(currencyRateData: JsonObject): CryptoCurrency {
        return CryptoCurrency(
            id = currencyRateData.get("id").asInt,
            symbol = currencyRateData.get("symbol").asString,
            name = currencyRateData.get("name").asString
        )
    }

}