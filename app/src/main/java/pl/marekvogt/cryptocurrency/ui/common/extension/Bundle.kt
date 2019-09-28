package pl.marekvogt.cryptocurrency.ui.common.extension

import android.os.Bundle

inline fun <reified T> Bundle.getSerializable(key: String): T? = getSerializable(key) as? T