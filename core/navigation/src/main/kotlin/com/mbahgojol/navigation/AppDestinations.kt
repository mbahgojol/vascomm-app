package com.mbahgojol.navigation

import com.mbahgojol.base.navigator.AppScreen

sealed class AppDestinations {
  object Login : AppScreen("loginScreen")
  object Dashboard : AppScreen("dashboardScreen")
  object Register : AppScreen("registerScreen")
}
