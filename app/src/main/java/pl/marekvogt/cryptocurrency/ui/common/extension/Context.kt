package pl.marekvogt.cryptocurrency.ui.common.extension

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Context.getDrawableByIdentifier(identifier: String): Int? =
    resources.getIdentifier(identifier, "drawable", packageName).takeIf { it != 0 }

infix fun View.showMessage(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}