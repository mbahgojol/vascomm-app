package com.mbahgojol.account.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mbahgojol.account.profile.ProfileScreen
import com.mbahgojol.navigation.AppDestinations

typealias OnBackClick = () -> Unit
typealias OnClickUnit = () -> Unit

fun NavGraphBuilder.profileNavigation() {
  composable(AppDestinations.ProfileScreen.name) {
    ProfileScreen()
  }
}
