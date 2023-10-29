package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.mbahgojol.resources.R

@Composable
fun FindIcon() {
  Box(contentAlignment = Alignment.TopStart) {
    Icon(painterResource(R.drawable.ic_bg_find), null)
    Icon(painterResource(R.drawable.ic_find), null)
  }
}
