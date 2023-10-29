package com.mbahgojol.account.profile.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.GreyN30
import com.mbahgojol.designsystem.Secondary
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.resources.R

@Composable
fun ChoosePersonalDataCard() {
  Row(
    Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    Icon(
      painterResource(R.drawable.ic_pin_user), null,
      tint = appColorScheme.primary,
      modifier = Modifier.background(
        color = Secondary,
        shape = CircleShape
      ).padding(8.dp)
    )
    Column {
      Text(
        stringResource(R.string.personal_data),
        style = appTypography.bodyMedium.copy(
          color = Color(0xFF333333),
          fontWeight = FontWeight.W600,
        )
      )
      Text(
        stringResource(R.string.personal_data_matches_ktp),
        style = appTypography.labelSmall.copy(
          fontWeight = FontWeight.W400,
          fontSize = 10.sp
        )
      )
    }
    Icon(
      painterResource(R.drawable.ic_map_marker), null,
      tint = appColorScheme.primary,
      modifier = Modifier
        .size(36.dp)
        .background(
          color = GreyN30,
          shape = CircleShape
        ).padding(8.dp)
    )
  }
}
