package pl.marekvogt.cryptocurrency.ui.detail

import android.content.Context
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.ui.common.view.LabelValue
import pl.marekvogt.cryptocurrency.ui.list.CryptoCurrencyRateViewEntity
import javax.inject.Inject

interface CryptoCurrencyDetailsMapper {
    fun map(viewEntity: CryptoCurrencyRateViewEntity): List<LabelValue>
}

class DefaultCryptoCurrencyDetailsMapper @Inject constructor(
    private val context: Context
) : CryptoCurrencyDetailsMapper {

    override fun map(viewEntity: CryptoCurrencyRateViewEntity): List<LabelValue> =
        listOf(
            LabelValue(context.getString(R.string.l_name), viewEntity.currency.name),
            LabelValue(context.getString(R.string.l_symbol), viewEntity.currency.symbol),
            LabelValue(context.getString(R.string.l_price), viewEntity.price),
            LabelValue(context.getString(R.string.l_day_volume), viewEntity.dayVolume),
            LabelValue(context.getString(R.string.l_circulating_supply), viewEntity.circulatingSupply),
            LabelValue(context.getString(R.string.l_max_supply), viewEntity.maxSupply),
            LabelValue(context.getString(R.string.l_total_supply), viewEntity.totalSupply),
            LabelValue(context.getString(R.string.l_hour_change), viewEntity.hourChange),
            LabelValue(context.getString(R.string.l_day_change), viewEntity.dayChange),
            LabelValue(context.getString(R.string.l_week_change), viewEntity.weekChange)
        )
}