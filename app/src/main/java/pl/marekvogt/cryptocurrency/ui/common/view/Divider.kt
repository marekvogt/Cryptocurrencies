package pl.marekvogt.cryptocurrency.ui.common.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import pl.marekvogt.cryptocurrency.R
import pl.marekvogt.cryptocurrency.ui.common.extension.inflate

class Divider(context: Context, attrs: AttributeSet? = null): FrameLayout(context, attrs) {

    init {
        inflate(R.layout.view_divider, true)
    }
}