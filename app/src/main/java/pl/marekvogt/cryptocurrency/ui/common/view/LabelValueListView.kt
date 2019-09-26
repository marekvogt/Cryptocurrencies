package pl.marekvogt.cryptocurrency.ui.common.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.DimenRes
import pl.marekvogt.cryptocurrency.R

class LabelValueListView(
    context: Context,
    private val attrs: AttributeSet
) : LinearLayout(context, attrs) {

    init {
        orientation = VERTICAL
        layoutParams = createLayoutParams(
            horizontalMarginRes = R.dimen.layout_horizontal_spacing
        )
    }

    fun add(labelValue: LabelValue) {
        addView(LabelValueView(context, attrs).apply {
            layoutParams = createLayoutParams(
                horizontalMarginRes = R.dimen.layout_horizontal_spacing,
                verticalMarginRes = R.dimen.list_item_spacing
            )
            bind(labelValue)
        })
        addView(Divider(context).apply {
            layoutParams = createLayoutParams(horizontalMarginRes = R.dimen.divider_horizontal_spacing)
        })

    }

    fun addAll(labelValues: List<LabelValue>) {
        labelValues.forEach { add(it) }
    }

    private fun createLayoutParams(@DimenRes horizontalMarginRes: Int?, @DimenRes verticalMarginRes: Int? = null) =
        LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
            val horizontalMargin = horizontalMarginRes?.let { resources.getDimensionPixelSize(horizontalMarginRes) } ?: 0
            val verticalMargin = verticalMarginRes?.let { resources.getDimensionPixelSize(it) } ?: 0
            setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin)
        }
}