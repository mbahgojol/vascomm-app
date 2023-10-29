package com.mbahgojol.dashboard.navigation

import com.mbahgojol.base.navigator.AppScreen

sealed class DashboardDestinations {
  object HomeScreen : AppScreen("homeScreen")
  object ProfileScreen : AppScreen("profileScreen")
}
