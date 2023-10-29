package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun IconWithText(
  painter: Painter = painterResource(R.drawable.ic_hospital),
  text: String,
  textStyle: TextStyle = appTypography.labelMedium
    .copy(
      fontWeight = FontWeight.W600,
      lineHeight = 17.sp
    ),
) {
  Row(
    Modifier.wrapContentSize(),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(painter, null)
    AppSpacer(width = 10.dp)
    Text(
      text = text,
      style = textStyle,
    )
  }
}
