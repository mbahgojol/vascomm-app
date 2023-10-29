package com.mbahgojol.dashboard.profile.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.resources.R

@Composable
fun MemberCard(
  modifier: Modifier = Modifier,
) {
  Card(
    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    shape = RoundedCornerShape(20.dp),
    modifier = modifier.fillMaxWidth()
  ) {
    ConstraintLayout(Modifier.fillMaxWidth().wrapContentHeight()) {
      val (infoCompleteWording, infoUser) = createRefs()
      Image(
        painterResource(R.drawable.img_memer_card), null,
        modifier = Modifier.clip(RoundedCornerShape(20.dp)).fillMaxWidth(),
        contentScale = ContentScale.Crop,
      )
      InfoUserCard(Modifier.constrainAs(infoUser) {
        top.linkTo(parent.top, margin = 30.dp)
        start.linkTo(parent.start, margin = 30.dp)
      })
      Text(
        stringResource(R.string.complete_your_profile_wording),
        modifier = Modifier.constrainAs(infoCompleteWording) {
          bottom.linkTo(parent.bottom, margin = 14.dp)
          start.linkTo(parent.start, margin = 16.dp)
        },
        style = appTypography.labelSmall
          .copy(
            fontWeight = FontWeight.W400,
            letterSpacing = 0.24.sp,
            color = Color.White
          )
      )
    }
  }
}
