package com.mbahgojol.designsystem.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mbahgojol.designsystem.GilroyFamily
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun InfoNotifCard() {
  Box(Modifier.fillMaxWidth()) {
    Image(painterResource(R.drawable.img_info_notification), null)
    Row(
      Modifier.fillMaxWidth()
        .padding(horizontal = 16.dp)
        .align(Alignment.Center),
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(
        stringResource(R.string.ask_want_to_get_update),
        style = appTypography.labelLarge
          .copy(
            fontWeight = FontWeight.W700,
            fontFamily = GilroyFamily,
            color = Color.White,
            textAlign = TextAlign.Start,
          )
      )
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
          stringResource(R.string.get_notification),
          style = appTypography.labelMedium.copy(
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Right,
            color = Color.White
          )
        )
        AppSpacer(width = 16.dp)
        Icon(
          painterResource(R.drawable.ic_arrow_right), null,
          tint = Color.White,
        )
      }
    }
  }
}
