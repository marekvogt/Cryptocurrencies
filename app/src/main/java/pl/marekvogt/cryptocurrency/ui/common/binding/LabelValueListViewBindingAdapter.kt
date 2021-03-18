package pl.marekvogt.cryptocurrency.ui.common.binding

import androidx.databinding.BindingAdapter
import pl.marekvogt.cryptocurrency.ui.common.view.LabelValue
import pl.marekvogt.cryptocurrency.ui.common.view.LabelValueListView

@BindingAdapter("bind")
fun bindLabelValues(labelValueListView: LabelValueListView, labelValues: List<LabelValue>?) {
    labelValues?.let { labelValueListView.bind(it) }
}