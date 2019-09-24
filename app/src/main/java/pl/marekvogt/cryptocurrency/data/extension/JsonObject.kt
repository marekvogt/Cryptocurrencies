package pl.marekvogt.cryptocurrency.data.extension

import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import java.math.BigDecimal

fun JsonObject.getBigDecimal(key: String): BigDecimal = get(key).asBigDecimal

fun JsonObject.getBigDecimalOrNull(key: String): BigDecimal? = (get(key) as? JsonPrimitive)?.asBigDecimal

fun JsonObject.getString(key: String): String = get(key)?.asString.orEmpty()

fun JsonObject.getInt(key: String): Int = get(key)?.asInt ?: 0