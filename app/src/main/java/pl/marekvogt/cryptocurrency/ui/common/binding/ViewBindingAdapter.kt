package pl.marekvogt.cryptocurrency.ui.common.binding

import android.view.View
import androidx.databinding.BindingAdapter
import pl.marekvogt.cryptocurrency.ui.common.extension.isVisibleWhen


@BindingAdapter("android:visibility")
fun setVisibility(view: View, shouldBeVisible: Boolean) {
    view isVisibleWhen shouldBeVisible
}