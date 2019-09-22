package pl.marekvogt.cryptocurrency.ui.common.binding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter


@BindingAdapter("srcCompat")
fun bindSrcCompat(imageView: ImageView, @DrawableRes drawableRes: Int) {
    imageView.setImageDrawable(imageView.context.getDrawable(drawableRes))
}