package com.mbahgojol.navigation

import com.mbahgojol.base.navigator.AppScreen

sealed class AppDestinations {
  object LoginScreen : AppScreen("loginScreen")
  object HomeScreen : AppScreen("homeScreen")
  object RegisterScreen : AppScreen("registerScreen")
  object ProfileScreen : AppScreen("profileScreen")
}
