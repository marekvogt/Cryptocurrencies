package pl.marekvogt.cryptocurrency.data.cache

interface Cacheable {
    fun invalidateCache()
}

class Cached<T>(private val emptyValue: T) {

    private var cached: T = emptyValue

    suspend fun get(freshDataSource: suspend () -> T, cacheValidityPredicate: (T) -> Boolean): T {
        return cached.takeIf(cacheValidityPredicate) ?: freshDataSource.invoke()
    }

    fun clearCache() {
        cached = emptyValue
    }
}