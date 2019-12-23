package pl.marekvogt.cryptocurrency.data.cache

class Cached<T>(private val emptyValue: T) {

    private var cache: T = emptyValue

    suspend fun get(freshDataSource: suspend () -> T, cacheValidityPredicate: (T) -> Boolean): T {
        return cache.takeIf(cacheValidityPredicate) ?: freshDataSource.invoke().also { cache = it }
    }

    fun clearCache() {
        cache = emptyValue
    }
}