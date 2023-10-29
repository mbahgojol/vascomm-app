package com.mbahgojol.dashboard.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mbahgojol.dashboard.home.widgets.AppTopBar
import com.mbahgojol.dashboard.home.widgets.InfoHealthCard
import com.mbahgojol.dashboard.home.widgets.InfoNotifCard
import com.mbahgojol.dashboard.home.widgets.InspectionTrackCard
import com.mbahgojol.dashboard.home.widgets.ListProductCard
import com.mbahgojol.dashboard.home.widgets.ListTypeHealthService
import com.mbahgojol.dashboard.home.widgets.SearchBar
import com.mbahgojol.dashboard.home.widgets.SpecialServiceCard
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
      Modifier.verticalScroll(rememberScrollState())
        .padding(it)
    ) {
      Column(
        Modifier.padding(horizontal = 16.dp)
      ) {
        AppSpacer(height = 16.dp)
        InfoHealthCard(
          Modifier.fillMaxWidth()
            .wrapContentHeight()
        )
        AppSpacer(height = 20.dp)
        SpecialServiceCard()
        AppSpacer(height = 16.dp)
        InspectionTrackCard()
        AppSpacer(height = 24.dp)
        SearchBar()
      }
      AppSpacer(height = 24.dp)
      ListProductCard()
      AppSpacer(height = 16.dp)
      ListTypeHealthService(Modifier.padding(horizontal = 16.dp))
      AppSpacer(height = 20.dp)
      InfoNotifCard()
    }
  }
}
