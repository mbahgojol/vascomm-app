package com.mbahgojol.base.exceptions

import org.json.JSONObject
import timber.log.Timber

data class HttpErrorResponse(
  val code: String,
  val message: String,
  val status: String,
)

fun String.toHttpErrorResponse(): HttpErrorResponse {
  try {
    val jsonObject = JSONObject(this)
    return HttpErrorResponse(
      code = "",
      message = jsonObject.getString("error"),
      status = "",
    )
  } catch (e: Exception) {
    Timber.tag("JsonSyntax-HttpErrorResponse").e(e.message.toString())
    throw JsonSyntaxError()
  }
}
