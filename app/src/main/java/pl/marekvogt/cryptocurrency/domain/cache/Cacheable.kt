package pl.marekvogt.cryptocurrency.domain.cache

interface Cacheable {
    fun invalidateCache()
}