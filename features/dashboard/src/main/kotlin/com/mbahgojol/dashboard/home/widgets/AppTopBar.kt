package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onClickNavigationIcon: () -> Unit) {
  TopAppBar(
    navigationIcon = {
      IconButton(
        onClick = onClickNavigationIcon,
      ) {
        Icon(
          painterResource(R.drawable.ic_menu), null,
          tint = appColorScheme.primary,
        )
      }
    },
    title = {},
    actions = {
      IconButton(
        onClick = {},
      ) {
        Icon(
          painterResource(R.drawable.ic_cart), null,
          tint = appColorScheme.primary,
        )
      }
      AppSpacer(width = 16.dp)
      BadgedBox(badge = {
        Badge(Modifier.size(10.dp)) { }
      }) {
        Icon(
          painterResource(R.drawable.ic_notification), null,
          tint = appColorScheme.primary,
        )
      }
      AppSpacer(width = 16.dp)
    },
  )
}
