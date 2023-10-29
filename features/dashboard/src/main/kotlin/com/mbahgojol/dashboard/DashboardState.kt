package com.mbahgojol.dashboard

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DashboardState(
  val drawerState: DrawerState,
  private val scope: CoroutineScope,
) {

  fun closeOrOpenDrawer() {
    scope.launch {
      drawerState.apply {
        if (isClosed) open() else close()
      }
    }
  }
}

@Composable
fun rememberDashboardState(
  drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
  scope: CoroutineScope = rememberCoroutineScope(),
) = remember {
  DashboardState(
    drawerState = drawerState,
    scope = scope,
  )
}
