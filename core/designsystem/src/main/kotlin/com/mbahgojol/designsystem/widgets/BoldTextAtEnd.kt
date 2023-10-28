package com.mbahgojol.designsystem.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.GilroyFamily

@Composable
fun BoldTextAtEnd(
  modifier: Modifier = Modifier,
  text: String,
  fontSize: TextUnit = 28.sp,
  color: Color = MaterialTheme.colorScheme.onPrimary,
) {
  val parts = text.split(", ")
  val normalText = parts[0]
  val boldText = parts[1]

  val annotatedString = buildAnnotatedString {
    withStyle(
      style = SpanStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = GilroyFamily,
        fontSize = fontSize,
        color = color
      ),
    ) {
      append(normalText.plus(", "))
    }
    withStyle(
      style = SpanStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = GilroyFamily,
        fontSize = fontSize,
        color = color
      ),
    ) {
      append(boldText)
    }
  }

  Text(
    modifier = modifier,
    text = annotatedString,
  )
}
