package com.mbahgojol.navigation

sealed class AppDestinations {
  object Login : AppScreen("loginScreen")
  object Dashboard : AppScreen("dashboardScreen")
  object Register : AppScreen("registerScreen")
}
