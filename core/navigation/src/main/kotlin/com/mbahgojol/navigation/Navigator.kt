package com.mbahgojol.navigation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mbahgojol.designsystem.AppTheme

val LocalNavigator =
  staticCompositionLocalOf<NavHostController> { error("No navigation host controller provided.") }


@Composable
fun ComponentActivity.KompasCompositionLocal(content: @Composable (navHostController: NavHostController) -> Unit) {
  CompositionLocalProvider(
    LocalNavigator provides rememberNavController(),
    LocalActivity provides this,
  ) {
    val navHostController = LocalNavigator.current
    content.invoke(navHostController)
  }
}

val LocalActivity = staticCompositionLocalOf<ComponentActivity> {
  noLocalProvidedFor("LocalActivity")
}

private fun noLocalProvidedFor(name: String): Nothing {
  error("CompositionLocal $name not present")
}

fun Context.findActivity(): Activity {
  var context = this
  while (context is ContextWrapper) {
    if (context is Activity) return context
    context = context.baseContext
  }
  throw IllegalStateException("no activity")
}

fun NavController.goTo(appScreen: AppScreen) {
  navigate(appScreen.name)
}

@Composable
fun ComponentActivity.Navigator(
  startDestination: String,
  graph: NavGraphBuilder.(NavHostController) -> Unit,
) {
  KompasCompositionLocal { navController ->
    AppTheme {
      Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
      ) {
        NavHost(
          navController = navController, startDestination = startDestination,
        ) {
          graph.invoke(this, navController)
        }
      }
    }
  }
}
