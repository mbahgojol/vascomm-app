package com.mbahgojol.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mbahgojol.dashboard.DashboardScreen
import com.mbahgojol.navigation.AppDestinations

typealias OnBackClick = () -> Unit
typealias OnClickUnit = () -> Unit

fun NavGraphBuilder.dashboardNavigation() {
  composable(AppDestinations.Dashboard.name) {
    DashboardScreen()
  }
}
