package com.mbahgojol.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mbahgojol.resources.R

val GilroyFamily = FontFamily(
  Font(R.font.gilroy_light, FontWeight.Normal),
  Font(R.font.gilroy_light, FontWeight.Medium),
  Font(R.font.gilroy_extrabold, FontWeight.SemiBold),
  Font(R.font.gilroy_extrabold, FontWeight.Bold),
  Font(R.font.gilroy_light, FontWeight.Light)
)

val ProxiFamily = FontFamily(
  Font(R.font.proximanova_light, FontWeight.Normal),
  Font(R.font.proximanova_light, FontWeight.Medium),
  Font(R.font.proximanova_extrabold, FontWeight.SemiBold),
  Font(R.font.proximanova_extrabold, FontWeight.Bold),
  Font(R.font.proximanova_light, FontWeight.Light)
)

val AppTypography: Typography
  @Composable get() {
    val default = Typography()
    val fontFamily = ProxiFamily
    return Typography(
      displayLarge = default.displayLarge.copy(fontFamily = fontFamily),
      displayMedium = default.displayMedium.copy(fontFamily = fontFamily),
      displaySmall = default.displaySmall.copy(fontFamily = fontFamily),
      headlineLarge = default.headlineLarge.copy(fontFamily = fontFamily),
      headlineMedium = default.headlineMedium.copy(fontFamily = fontFamily),
      headlineSmall = default.headlineSmall.copy(fontFamily = fontFamily),
      titleLarge = default.titleLarge.copy(fontFamily = fontFamily),
      titleMedium = default.titleMedium.copy(fontFamily = fontFamily),
      titleSmall = default.titleSmall.copy(fontFamily = fontFamily),
      bodyLarge = default.bodyLarge.copy(fontFamily = fontFamily),
      bodyMedium = default.bodyMedium.copy(fontFamily = fontFamily),
      bodySmall = default.bodySmall.copy(fontFamily = fontFamily),
      labelLarge = default.labelLarge.copy(fontFamily = fontFamily),
      labelMedium = default.labelMedium.copy(fontFamily = fontFamily),
      labelSmall = default.labelSmall.copy(fontFamily = fontFamily),
    ).copy(
      bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = GreyText,
      ), titleLarge = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        color = GreyText,
      ), titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 25.sp,
        color = GreyText,
      ), labelLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        textAlign = TextAlign.Center,
        color = GreyText,
      ), labelMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = GreyText,
      ), labelSmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = GreyText,
      ), bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = GreyText,
      )
    )
  }
