package pl.marekvogt.cryptocurrency.ui.common.extension

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Context.getDrawableByName(name: String): Int? =
    resources.getIdentifier(name, "drawable", packageName).takeIf { it != 0 && it != name.toIntOrNull() }

infix fun View.showMessage(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}