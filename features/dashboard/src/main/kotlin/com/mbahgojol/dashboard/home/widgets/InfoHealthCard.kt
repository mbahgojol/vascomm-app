package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.designsystem.widgets.BoldTextAtEnd
import com.mbahgojol.resources.R

@Composable
fun InfoHealthCard(modifier: Modifier = Modifier) {
  val brush = Brush.horizontalGradient(listOf(Color(0xFFFAFAFA), Color(0xFFDAE9F9)))

  Box(
    contentAlignment = Alignment.TopEnd,
    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
  ) {
    Card(
      modifier.padding(top = 30.dp).wrapContentHeight(),
      shape = RoundedCornerShape(16.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 50.dp),
    ) {
      Column(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(
          brush = brush,
        ).padding(
          horizontal = 15.dp, vertical = 16.dp
        )
      ) {
        BoldTextAtEnd(
          text = stringResource(R.string.solution_your_health),
          fontSize = 18.sp,
          color = MaterialTheme.colorScheme.primary
        )
        AppSpacer(height = 8.dp)
        Text(
          stringResource(R.string.health_info),
          style = appTypography.labelSmall.copy(
            fontWeight = FontWeight.W400,
          ),
        )
        AppSpacer(height = 12.dp)
        Row(
          Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          AppButton(
            text = stringResource(R.string.more), onClick = {

            },
            modifier = Modifier
              .wrapContentSize()
          )
          Image(painterResource(R.drawable.ic_dot_indicator), null)
        }
      }
    }
    Image(painterResource(R.drawable.ic_calendar_time), null)
  }
}
