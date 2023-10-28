package com.mbahgojol.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

private typealias OnBackClick = () -> Unit

@Composable
fun LoginScreen(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
) {
  LoginUi(
    onBackClick = onBackClick,
    modifier = modifier,
  )
}

@Composable
private fun LoginUi(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
  greeting: Greeting = koinInject(),
) {
  Text(greeting.name())
}
