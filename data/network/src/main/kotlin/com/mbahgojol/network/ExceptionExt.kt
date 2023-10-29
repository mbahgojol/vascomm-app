@file:Suppress("unused")

package com.mbahgojol.network

import com.google.gson.JsonSyntaxException
import com.mbahgojol.base.NetworkHelper
import com.mbahgojol.base.exceptions.JsonSyntaxError
import com.mbahgojol.base.exceptions.NoInternetConnection

inline fun <T> safeRequest(
  block: () -> T,
): T = try {
  block.invoke()
} catch (e: JsonSyntaxException) {
  throw JsonSyntaxError()
} catch (e: Throwable) {
  throw e
}

suspend fun <T> NetworkHelper.safeNetworkCall(requestData: suspend () -> T): T =
  when (isNetworkConnected()) {
    true -> {
      requestData.invoke()
    }

    false -> throw NoInternetConnection()
  }
