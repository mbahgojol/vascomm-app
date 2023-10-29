package com.mbahgojol.designsystem.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.GilroyFamily
import com.mbahgojol.resources.R

@Composable
fun AppButtonWithIcon(
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
  text: String,
  backgroundColor: Color = MaterialTheme.colorScheme.primary,
  painter: Painter = painterResource(R.drawable.ic_arrow_right),
) {
  Box(
    modifier
      .background(
        color = backgroundColor,
        shape = RoundedCornerShape(8.dp)
      )
      .clickable(
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(bounded = true),
      ),
  ) {
    Text(
      text = text,
      modifier = Modifier.wrapContentSize()
        .align(Alignment.Center),
      style = MaterialTheme.typography.labelLarge.copy(
        lineHeight = 24.sp,
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        color = Color.White,
      ),
    )
    Icon(
      painter,
      null,
      modifier = Modifier.align(Alignment.CenterEnd)
        .padding(horizontal = 20.dp),
      tint = Color.White,
    )
  }
}
