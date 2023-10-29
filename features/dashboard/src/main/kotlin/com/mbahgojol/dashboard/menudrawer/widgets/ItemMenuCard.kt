package com.mbahgojol.dashboard.menudrawer.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mbahgojol.dashboard.navigation.OnClickUnit
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer

@Composable
fun ItemMenuCard(
  onClickUnit: OnClickUnit,
  text: String,
) {
  Row(
    Modifier.clickable(
      onClick = onClickUnit,
      interactionSource = remember { MutableInteractionSource() },
      indication = rememberRipple(bounded = true)
    ).wrapContentSize(), verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text, style = appTypography.labelSmall.copy(
        fontWeight = FontWeight.W600,
      ), modifier = Modifier.padding(vertical = 10.dp)
    )
    AppSpacer(width = 50.dp)
    Icon(Icons.Default.KeyboardArrowRight, null)
  }
}
