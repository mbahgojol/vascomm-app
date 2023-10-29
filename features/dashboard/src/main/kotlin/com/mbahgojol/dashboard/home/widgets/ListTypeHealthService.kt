package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.Orange
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun ListTypeHealthService(modifier: Modifier = Modifier) {
  Column(modifier.fillMaxWidth()) {
    Text(
      stringResource(R.string.select_your_health),
      style = appTypography.labelLarge
        .copy(
          fontWeight = FontWeight.W600,
          color = appColorScheme.primary,
        )
    )
    AppSpacer(height = 22.dp)
    TypeHealthServiceTab()
    AppSpacer(height = 30.dp)
    ItemHealthService(painterResource(R.drawable.img_hospital_1))
    AppSpacer(height = 25.dp)
    ItemHealthService(painterResource(R.drawable.img_hospital_2))
  }
}

@Composable
fun ItemHealthService(
  painter: Painter,
) {
  Card(
    colors = CardDefaults.cardColors(containerColor = Color.White),
    shape = RoundedCornerShape(16.dp),
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp)
  ) {
    Row(
      Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Column(
        Modifier.padding(
          top = 10.dp,
          start = 20.dp,
          bottom = 15.dp,
        )
      ) {
        Text(
          "PCR Swab Test (Drive Thru)\nHasil 1 Hari Kerja",
          style = appTypography.labelMedium
            .copy(
              color = appColorScheme.primary,
              fontWeight = FontWeight.W600,
              lineHeight = 17.sp
            )
        )
        AppSpacer(height = 12.dp)
        Text(
          "Rp. 1.400.000",
          style = appTypography.labelMedium
            .copy(
              color = Orange,
              fontWeight = FontWeight.W600,
              lineHeight = 17.sp
            )
        )
        AppSpacer(height = 20.dp)
        IconWithText(
          painterResource(R.drawable.ic_hospital),
          text = "Lenmarc Surabaya",
          textStyle = appTypography.labelMedium
            .copy(
              fontWeight = FontWeight.W600,
              lineHeight = 17.sp
            ),
        )
        AppSpacer(height = 8.dp)
        IconWithText(
          painterResource(R.drawable.ic_location),
          text = "Dukuh Pakis, Surabaya",
          textStyle = appTypography.labelSmall
            .copy(
              fontWeight = FontWeight.W400,
              lineHeight = 15.sp
            ),
        )
      }
      Image(
        painter, null,
        modifier = Modifier
          .clip(RoundedCornerShape(16.dp))
          .fillMaxWidth(0.7f)
          .fillMaxHeight()
          .heightIn(min = 150.dp),
        contentScale = ContentScale.Crop,
      )
    }
  }
}
