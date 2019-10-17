package pl.marekvogt.cryptocurrency.ui.detail.mapper

import pl.marekvogt.cryptocurrency.ui.detail.CryptoCurrencyDetailsMapper
import pl.marekvogt.cryptocurrency.ui.detail.testLabelValueData
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import pl.marekvogt.cryptocurrency.ui.list.testCurrencyRateViewEntity

class FakeCryptoCurrencyDetailsMapper : CryptoCurrencyDetailsMapper {

    private val mapper = mapOf(
        testCurrencyRateViewEntity to testLabelValueData
    )

    override fun map(viewEntity: CryptoCurrencyRateViewEntity) = mapper[viewEntity] ?: error("Unknown test model")

}