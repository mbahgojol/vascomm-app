package com.mbahgojol.designsystem.utils

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun <T> stateOf(value: T) = remember {
  mutableStateOf(value)
}

@Composable
fun <T> derivedStateOf(calculation: () -> T) = remember {
  derivedStateOf(calculation)
}

val appTypography: Typography
  @Composable get() = MaterialTheme.typography


val appColorScheme: ColorScheme
  @Composable get() = MaterialTheme.colorScheme


val appShapes: Shapes
  @Composable get() = MaterialTheme.shapes
