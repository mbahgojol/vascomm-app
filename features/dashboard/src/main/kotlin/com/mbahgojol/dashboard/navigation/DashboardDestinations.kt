package com.mbahgojol.dashboard.navigation

import com.mbahgojol.navigation.AppScreen

sealed class DashboardDestinations {
  object HomeScreen : AppScreen("homeScreen")
  object ProfileScreen : AppScreen("profileScreen")
}
