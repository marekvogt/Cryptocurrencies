package pl.marekvogt.cryptocurrency.ui.common.error

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import pl.marekvogt.cryptocurrency.R
import javax.inject.Inject

interface ErrorMessageResolver {
    fun resolve(throwable: Throwable): String
}

class DefaultErrorMessageResolver @Inject constructor(
    @ApplicationContext private val context: Context
) : ErrorMessageResolver {

    override fun resolve(throwable: Throwable): String =
        throwable.message ?: context.getString(R.string.e_unknown_error)
}