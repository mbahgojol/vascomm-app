package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.GilroyFamily

@Composable
fun AppButton(
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
  text: String,
  backgroundColor: Color = MaterialTheme.colorScheme.primary,
) {
  Text(
    text = text,
    modifier = modifier.wrapContentSize()
      .background(
        color = backgroundColor, shape = RoundedCornerShape(8.dp)
      ).clickable(
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = true),
      ).padding(horizontal = 13.dp, vertical = 7.dp),
    style = MaterialTheme.typography.labelSmall.copy(
      lineHeight = 18.sp,
      fontFamily = GilroyFamily,
      fontWeight = FontWeight.W600,
      textAlign = TextAlign.Center,
      color = Color.White,
    ),
  )
}
