package com.mbahgojol.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface AppDispatchers {
  val io: CoroutineDispatcher
  val main: CoroutineDispatcher
  val default: CoroutineDispatcher
}

internal class AppDispatchersImpl : AppDispatchers {
  override val io: CoroutineDispatcher = Dispatchers.IO
  override val main: CoroutineDispatcher = Dispatchers.Main
  override val default: CoroutineDispatcher = Dispatchers.Default
}

suspend fun <T> T.dispatcherOn(coroutineDispatcher: CoroutineDispatcher): T {
  return withContext(coroutineDispatcher) {
    this@dispatcherOn
  }
}
