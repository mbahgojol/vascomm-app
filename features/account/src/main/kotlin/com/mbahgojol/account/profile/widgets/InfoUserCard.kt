package com.mbahgojol.account.profile.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mbahgojol.designsystem.utils.appTypography

@Composable
fun InfoUserCard(modifier: Modifier = Modifier) {
  Row(modifier.wrapContentSize()) {
    PhotosCircle()
    Column(Modifier.padding(start = 16.dp)) {
      MemberNameText()
      Text(
        "Membership BBLK", style = appTypography.labelMedium.copy(
          fontWeight = FontWeight.W600,
        )
      )
    }
  }
}
