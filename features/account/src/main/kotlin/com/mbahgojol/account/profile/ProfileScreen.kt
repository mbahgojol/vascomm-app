package com.mbahgojol.account.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mbahgojol.account.navigation.OnBackClick

@Composable
internal fun ProfileScreen(
  modifier: Modifier = Modifier,
) {
  ProfileUi(
    onBackClick = {},
    modifier = modifier,
  )
}

@Composable
private fun ProfileUi(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
) {

}
