package com.mbahgojol.account.profile.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.GilroyFamily

@Composable
fun MemberNameText() {
  val annotatedString = buildAnnotatedString {
    withStyle(
      style = SpanStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = GilroyFamily,
        fontSize = 20.sp,
        color = Color.White
      ),
    ) {
      append("Angga ")
    }
    withStyle(
      style = SpanStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = GilroyFamily,
        fontSize = 20.sp,
        color = Color.White
      ),
    ) {
      append("Praja")
    }
  }

  Text(
    text = annotatedString,
  )
}
