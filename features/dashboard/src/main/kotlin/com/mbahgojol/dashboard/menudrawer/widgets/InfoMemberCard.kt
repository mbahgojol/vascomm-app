package com.mbahgojol.dashboard.menudrawer.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.MemberNameText
import com.mbahgojol.designsystem.widgets.PhotosCircle

@Composable
fun InfoMemberCard() {
  Row(Modifier.wrapContentSize()) {
    PhotosCircle()
    Column(Modifier.padding(start = 16.dp)) {
      MemberNameText(
        fontSize = 14.sp, color = appColorScheme.primary
      )
      Text(
        "Membership BBLK", style = appTypography.labelMedium.copy(
          fontWeight = FontWeight.W600, fontSize = 11.sp
        )
      )
    }
  }
}
