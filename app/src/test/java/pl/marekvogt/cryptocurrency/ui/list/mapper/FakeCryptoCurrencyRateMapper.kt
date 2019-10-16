package pl.marekvogt.cryptocurrency.ui.list.mapper

import pl.marekvogt.cryptocurrency.domain.model.CryptoCurrencyRate
import pl.marekvogt.cryptocurrency.domain.model.testCurrencyRate
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateMapper
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import pl.marekvogt.cryptocurrency.ui.list.testCurrencyRateViewEntity

class FakeCryptoCurrencyRateMapper : CryptoCurrencyRateMapper {

    private val mapper: Map<CryptoCurrencyRate, CryptoCurrencyRateViewEntity> = mapOf(
        testCurrencyRate to testCurrencyRateViewEntity
    )

    override fun map(
        currencyRate: CryptoCurrencyRate
    ): CryptoCurrencyRateViewEntity = mapper[testCurrencyRate] ?: error("Unknown test model")

}