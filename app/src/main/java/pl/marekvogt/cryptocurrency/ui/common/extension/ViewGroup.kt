package pl.marekvogt.cryptocurrency.ui.common.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutResId: Int, attachToRoot: Boolean): View =
    LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)