package com.mbahgojol.base.exceptions

data class ErrorState(
  var message: String,
  var code: String? = null,
)

fun Throwable.toErrorState(): ErrorState {
  return when (this) {
    is HttpErrorInternalServerError -> {
      ErrorState(
        message = "Oops! internal server error at our end",
        code = null,
      )
    }

    is HttpErrorConnectionTimeout -> {
      ErrorState(
        message = "Oops! failed connect to server.",
        code = "Timeout",
      )
    }

    is JsonSyntaxError -> {
      ErrorState(
        message = "Oops! Your json is not the same on the server. fix it. Wait!",
        code = null,
      )
    }

    is HttpError -> {
      ErrorState(
        message = httpErrorResponse?.message.orEmpty(),
        code = null,
      )
    }

    else -> {
      ErrorState(
        message = message.orEmpty(),
        code = null,
      )
    }
  }
}
