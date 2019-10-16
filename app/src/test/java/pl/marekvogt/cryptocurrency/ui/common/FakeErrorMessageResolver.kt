package pl.marekvogt.cryptocurrency.ui.common

import pl.marekvogt.cryptocurrency.ui.common.error.ErrorMessageResolver

const val errorMessage = "Error occurred"

class FakeErrorMessageResolver : ErrorMessageResolver {
    override fun resolve(throwable: Throwable): String = errorMessage
}