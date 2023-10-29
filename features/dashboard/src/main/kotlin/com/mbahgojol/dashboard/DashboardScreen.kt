package com.mbahgojol.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mbahgojol.dashboard.home.HomeScreen
import com.mbahgojol.dashboard.home.widgets.AppTopBar
import com.mbahgojol.dashboard.menudrawer.MenuDrawerContent
import com.mbahgojol.dashboard.navigation.DashboardDestinations
import com.mbahgojol.dashboard.profile.ProfileScreen

@Composable
fun DashboardScreen(
  navController: NavHostController = rememberNavController(),
  dashboardState: DashboardState = rememberDashboardState(),
) {
  ModalNavigationDrawer(
    drawerState = dashboardState.drawerState,
    drawerContent = {
      ModalDrawerSheet {
        MenuDrawerContent(
          onClickHomeScreen = {
            navController.navigate(DashboardDestinations.HomeScreen.name) {
              popUpTo(DashboardDestinations.ProfileScreen.name) {
                saveState = true
                inclusive = true
              }
              restoreState = true
              launchSingleTop = true
            }

            dashboardState.closeOrOpenDrawer()
          },
          onClickProfile = {
            navController.navigate(DashboardDestinations.ProfileScreen.name) {
              popUpTo(DashboardDestinations.HomeScreen.name) {
                saveState = true
                inclusive = true
              }
              restoreState = true
              launchSingleTop = true
            }

            dashboardState.closeOrOpenDrawer()
          },
        )
      }
    },
  ) {
    Scaffold(
      topBar = {
        AppTopBar {
          dashboardState.closeOrOpenDrawer()
        }
      },
    ) {
      NavHost(
        modifier = Modifier.padding(it),
        navController = navController,
        startDestination = DashboardDestinations.HomeScreen.name,
      ) {
        composable(DashboardDestinations.HomeScreen.name) {
          HomeScreen()
        }

        composable(DashboardDestinations.ProfileScreen.name) {
          ProfileScreen()
        }
      }
    }
  }
}
