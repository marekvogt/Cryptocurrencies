package pl.marekvogt.cryptocurrency.ui.detail

import android.content.Context
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.ui.common.view.LabelValue
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity

interface CryptoCurrencyDetailsMapper {
    fun map(viewEntity: CryptoCurrencyRateViewEntity) : List<LabelValue>
}

class DefaultCryptoCurrencyDetailsMapper(
    private val context: Context
) : CryptoCurrencyDetailsMapper {

    override fun map(viewEntity: CryptoCurrencyRateViewEntity): List<LabelValue> =
        listOf(
            LabelValue(context.getString(R.string.l_name), viewEntity.currency.name),
            LabelValue(context.getString(R.string.l_symbol), viewEntity.currency.symbol),
            LabelValue(context.getString(R.string.l_price), viewEntity.price)
        )
}