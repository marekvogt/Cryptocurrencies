package pl.marekvogt.cryptocurrency.ui.common.extension

import android.view.View
infix fun View.isVisibleWhen(condition: Boolean) = if (condition) show() else hide()

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}