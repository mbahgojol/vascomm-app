package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.dashboard.navigation.OnClickUnit
import com.mbahgojol.designsystem.GilroyFamily
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun AppTextButtonWithIcon(
  modifier: Modifier = Modifier,
  text: String,
  onClick: OnClickUnit,
  painter: Painter = painterResource(R.drawable.ic_arrow_right),
) {
  Row(
    modifier.clickable(
      onClick = onClick,
      interactionSource = remember { MutableInteractionSource() },
      indication = rememberRipple(bounded = true),
    ),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text,
      style = appTypography.bodyMedium.copy(
        fontWeight = FontWeight.W700,
        fontFamily = GilroyFamily,
        lineHeight = 21.sp,
        color = appColorScheme.primary,
      ),
    )
    AppSpacer(width = 8.dp)
    Icon(
      painter,
      null,
      tint = appColorScheme.primary,
    )
  }
}
