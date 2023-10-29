package com.mbahgojol.base

import timber.log.Timber
import java.util.concurrent.CancellationException

suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> = try {
  Result.success(block())
} catch (cancellationException: CancellationException) {
  throw cancellationException
} catch (exception: Exception) {
  Timber.tag("suspendRunCatching")
    .e(exception, "Failed to evaluate a suspendRunCatchingBlock. Returning failure Result")
  Result.failure(exception)
}
