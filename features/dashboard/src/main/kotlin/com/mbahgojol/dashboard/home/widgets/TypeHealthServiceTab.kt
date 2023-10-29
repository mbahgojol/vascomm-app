package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.Secondary
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer

@Composable
fun TypeHealthServiceTab() {
  Card(
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
    colors = CardDefaults.cardColors(
      containerColor = Color.White,
    ),
    shape = RoundedCornerShape(20.dp)
  ) {
    Row(Modifier.padding(vertical = 3.dp, horizontal = 4.dp)) {
      ItemTypeHealthService(
        selected = true,
        stringResource(com.mbahgojol.resources.R.string.unit_service)
      )
      AppSpacer(width = 4.dp)
      ItemTypeHealthService(
        selected = false,
        stringResource(com.mbahgojol.resources.R.string.inspection_package)
      )
    }
  }
}

@Composable
fun ItemTypeHealthService(
  selected: Boolean = false,
  text: String = stringResource(com.mbahgojol.resources.R.string.unit_service),
) {
  Text(
    text,
    style = appTypography.labelMedium
      .copy(
        lineHeight = 18.sp,
        fontWeight = if (selected) FontWeight.W600 else FontWeight.W400,
        color = appColorScheme.primary,
      ),
    modifier = Modifier
      .background(
        if (selected) {
          Secondary
        } else {
          Color.White
        },
        shape = RoundedCornerShape(20.dp)
      ).padding(
        vertical = 5.dp,
        horizontal = 16.dp
      )
  )
}
