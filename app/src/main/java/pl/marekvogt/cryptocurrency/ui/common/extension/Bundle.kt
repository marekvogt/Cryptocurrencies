package pl.marekvogt.cryptocurrency.ui.common.extension

import android.os.Bundle

fun Bundle.getIntOrNull(key: String) = getInt(key, Integer.MIN_VALUE).takeUnless { it == Integer.MIN_VALUE }