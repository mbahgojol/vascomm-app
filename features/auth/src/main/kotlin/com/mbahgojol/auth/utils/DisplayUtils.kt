package com.mbahgojol.auth.utils

import android.content.Context
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackBarState(
  private val context: Context,
  private val scope: CoroutineScope,
  private val snackbarHostState: SnackbarHostState,
) {
  fun showSnackBar(message: String) {
    scope.launch {
      snackbarHostState.showSnackbar(message = message)
    }
  }

  @Composable
  fun SnackBarHost() {
    SnackbarHost(hostState = snackbarHostState)
  }
}

@Composable
fun rememberSnackBarState(
  context: Context = LocalContext.current,
  scope: CoroutineScope = rememberCoroutineScope(),
  snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
) = remember {
  SnackBarState(context, scope, snackbarHostState)
}

typealias SnackBarHost = @Composable () -> Unit
