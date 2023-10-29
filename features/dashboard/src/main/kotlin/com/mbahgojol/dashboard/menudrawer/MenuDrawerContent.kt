package com.mbahgojol.dashboard.menudrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.dashboard.menudrawer.widgets.InfoMemberCard
import com.mbahgojol.dashboard.menudrawer.widgets.ItemMenuCard
import com.mbahgojol.dashboard.navigation.OnClickUnit
import com.mbahgojol.designsystem.Red
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun MenuDrawerContent(
  modifier: Modifier = Modifier,
  onClickHomeScreen: OnClickUnit,
  onClickProfile: OnClickUnit,
) {
  Column(
    Modifier.fillMaxSize().padding(
      horizontal = 16.dp, vertical = 30.dp
    )
  ) {
    InfoMemberCard()
    AppSpacer(height = 30.dp)
    ItemMenuCard(onClickHomeScreen, stringResource(R.string.first_page))
    AppSpacer(height = 16.dp)
    ItemMenuCard(onClickProfile, stringResource(R.string.my_profile))
    AppSpacer(height = 16.dp)
    ItemMenuCard({}, stringResource(R.string.setting))
    AppSpacer(height = 30.dp)
    Button(
      onClick = {},
      colors = ButtonDefaults.buttonColors(containerColor = Red),
      modifier = Modifier.width(130.dp)
    ) {
      Text(
        stringResource(R.string.logout), style = appTypography.labelSmall.copy(
          fontSize = 11.sp,
          color = Color.White,
        )
      )
    }
    AppSpacer(height = 80.dp)
    Row(
      Modifier.wrapContentSize().align(Alignment.CenterHorizontally),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        stringResource(R.string.follow_me_on), style = appTypography.labelLarge.copy(
          lineHeight = 20.sp,
          fontWeight = FontWeight.W500,
        )
      )
      AppSpacer(width = 12.dp)
      Icon(
        painterResource(R.drawable.ic_facebook), null, tint = appColorScheme.primary
      )
      AppSpacer(width = 12.dp)
      Icon(
        painterResource(R.drawable.ic_instagram), null, tint = appColorScheme.primary
      )
      AppSpacer(width = 12.dp)
      Icon(painterResource(R.drawable.ic_twitter), null, tint = appColorScheme.primary)
    }
  }
}
