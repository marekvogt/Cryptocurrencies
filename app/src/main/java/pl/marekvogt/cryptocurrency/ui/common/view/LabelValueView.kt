package pl.marekvogt.cryptocurrency.ui.common.view

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.view_label_value.view.*
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.ui.common.extension.inflate

class LabelValueView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        inflate(R.layout.view_label_value, true)
        orientation = VERTICAL
    }

    fun bind(labelValue: LabelValue) {
        txtLabel.text = labelValue.label
        txtValue.text = labelValue.value
    }
}

data class LabelValue(
    val label: String,
    val value: String
)