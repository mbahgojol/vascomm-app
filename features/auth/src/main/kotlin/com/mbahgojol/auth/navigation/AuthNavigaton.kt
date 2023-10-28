package com.mbahgojol.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mbahgojol.auth.login.LoginScreen
import com.mbahgojol.auth.register.RegisterScreen
import com.mbahgojol.navigation.AppDestinations

typealias OnBackClick = () -> Unit
typealias OnClickUnit = () -> Unit

fun NavGraphBuilder.authNavigation() {
  composable(AppDestinations.LoginScreen.name) {
    LoginScreen()
  }

  composable(AppDestinations.RegisterScreen.name) {
    RegisterScreen()
  }
}
