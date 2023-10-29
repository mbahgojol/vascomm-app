package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
  Row(
    modifier.fillMaxWidth()
  ) {
    IconButton(
      onClick = {},
      colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
    ) {
      Icon(painterResource(R.drawable.ic_filter), null)
    }
    AppSpacer(width = 16.dp)
    SearchCard()
  }
}
