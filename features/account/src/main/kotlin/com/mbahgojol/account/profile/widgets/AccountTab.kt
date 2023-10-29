package com.mbahgojol.account.profile.widgets

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
import com.mbahgojol.resources.R

@Composable
fun AccountTab() {
  Card(
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 50.dp),
    colors = CardDefaults.cardColors(
      containerColor = Color.White,
    ),
    shape = RoundedCornerShape(20.dp)
  ) {
    Row(Modifier.padding(vertical = 3.dp, horizontal = 4.dp)) {
      ItemTab(
        selected = true,
        stringResource(R.string.my_profile)
      )
      AppSpacer(width = 4.dp)
      ItemTab(
        selected = false,
        stringResource(R.string.setting)
      )
    }
  }
}

@Composable
private fun ItemTab(
  selected: Boolean = false,
  text: String,
) {
  Text(
    text,
    style = appTypography.labelLarge
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
