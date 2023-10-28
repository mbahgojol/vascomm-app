package com.mbahgojol.dashboard.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mbahgojol.dashboard.home.widgets.AppTopBar
import com.mbahgojol.dashboard.home.widgets.CardInfoHealth
import com.mbahgojol.dashboard.home.widgets.CardInspectionTrack
import com.mbahgojol.dashboard.home.widgets.CardSpecialService
import com.mbahgojol.dashboard.navigation.OnBackClick
import com.mbahgojol.designsystem.widgets.AppSpacer

@Composable
internal fun HomeScreen(
  modifier: Modifier = Modifier,
) {
  HomeUi(
    onBackClick = {},
    modifier = modifier,
  )
}

@Composable
private fun HomeUi(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    topBar = {
      AppTopBar()
    },
  ) {
    Column(
      Modifier.padding(it)
        .padding(horizontal = 16.dp)
    ) {
      AppSpacer(height = 16.dp)
      CardInfoHealth(
        Modifier.fillMaxWidth()
          .wrapContentHeight()
      )
      AppSpacer(height = 20.dp)
      CardSpecialService()
      AppSpacer(height = 20.dp)
      CardInspectionTrack()
      AppSpacer(height = 20.dp)
      SearchBar()
    }
  }
}

@Composable
fun SearchBar() {

}
