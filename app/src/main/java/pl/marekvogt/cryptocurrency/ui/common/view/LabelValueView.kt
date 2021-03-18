package pl.marekvogt.cryptocurrency.ui.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.marekvogt.cryptocurrency.databinding.ViewLabelValueBinding

class LabelValueView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding : ViewLabelValueBinding = ViewLabelValueBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        orientation = VERTICAL
    }

    fun bind(labelValue: LabelValue) {
        binding.labelValue = labelValue
    }
}

data class LabelValue(
    val label: String,
    val value: String
)