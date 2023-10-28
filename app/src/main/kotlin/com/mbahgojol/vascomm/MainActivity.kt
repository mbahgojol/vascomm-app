package com.mbahgojol.vascomm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mbahgojol.auth.navigation.authNavigation
import com.mbahgojol.base.navigator.Navigator
import com.mbahgojol.dashboard.navigation.dashboardNavigation
import com.mbahgojol.navigation.AppDestinations

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          Navigator(startDestination = AppDestinations.HomeScreen.name) {
            authNavigation()
            dashboardNavigation()
          }
        }
    }
}
