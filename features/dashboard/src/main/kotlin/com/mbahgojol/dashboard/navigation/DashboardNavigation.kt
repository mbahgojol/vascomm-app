package com.mbahgojol.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mbahgojol.dashboard.home.HomeScreen
import com.mbahgojol.navigation.AppDestinations

typealias OnBackClick = () -> Unit
typealias OnClickUnit = () -> Unit

fun NavGraphBuilder.dashboardNavigation() {
  composable(AppDestinations.HomeScreen.name) {
    HomeScreen()
  }
}
