package com.mbahgojol.designsystem

import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Pink40 = Color(0xFF7D5260)

val Primary = Color(0xFF002060)
val OnPrimary = Color(0xFF1D334F)

val GreyText = Color(0xFF597393)
val GreyN30 = Color(0xFFEBEDF7)
val Scarlet = Color(0xFFF32013)
val GreenDark = Color(0xFF007025)
val GreenLight = Color(0xFFB3FFCB)
val Orange = Color(0xFFFF7200)
val Secondary = Color(0xFF00D9D5)

val defaultTextFieldColors: TextFieldColors
  @Composable get() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    errorContainerColor = Color.Transparent,
    errorLabelColor = Scarlet,
    errorPlaceholderColor = Scarlet,
    errorCursorColor = Scarlet,
    errorIndicatorColor = Scarlet
  )
