package pl.marekvogt.cryptocurrency.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import pl.marekvogt.cryptocurrency.databinding.ListItemCryptoCurrencyBinding
import pl.marekvogt.cryptocurrency.R


class CryptoCurrencyListAdapter
    : ListAdapter<CryptoCurrencyRateViewEntity, CryptoCurrencyListAdapter.ViewHolder>(CurrencyRateViewEntityDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItemBinding = DataBindingUtil.inflate<ListItemCryptoCurrencyBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_crypto_currency, parent, false
        )
        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewDataBinding.currencyRate = getItem(position)
    }

    class ViewHolder(
        val viewDataBinding: ListItemCryptoCurrencyBinding
    ) : RecyclerView.ViewHolder(viewDataBinding.root)
}

private object CurrencyRateViewEntityDiff : DiffUtil.ItemCallback<CryptoCurrencyRateViewEntity>() {
    override fun areItemsTheSame(
        oldItem: CryptoCurrencyRateViewEntity,
        newItem: CryptoCurrencyRateViewEntity
    ) = oldItem.currency.id == newItem.currency.id

    override fun areContentsTheSame(
        oldItem: CryptoCurrencyRateViewEntity,
        newItem: CryptoCurrencyRateViewEntity
    ) = oldItem == newItem
}