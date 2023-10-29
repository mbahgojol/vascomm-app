package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun SpecialServiceCard(modifier: Modifier = Modifier) {
  Box(
    contentAlignment = Alignment.TopEnd,
    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
  ) {
    Card(
      modifier.padding(top = 30.dp).wrapContentHeight(),
      shape = RoundedCornerShape(16.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
      Column(
        modifier = Modifier.fillMaxWidth()
          .wrapContentHeight()
          .padding(
            horizontal = 15.dp, vertical = 16.dp
          )
      ) {
        Text(
          text = stringResource(R.string.special_service),
          fontSize = 18.sp,
          color = MaterialTheme.colorScheme.primary
        )
        AppSpacer(height = 8.dp)
        Text(
          stringResource(R.string.test_covid_wording),
          style = appTypography.labelSmall.copy(
            fontWeight = FontWeight.W400,
          ),
        )
        AppSpacer(height = 12.dp)
        AppTextButtonWithIcon(
          text = stringResource(R.string.take_test), onClick = {

          }, modifier = Modifier.wrapContentSize()
        )
      }
    }
    Image(
      painterResource(R.drawable.ic_injection), null,
      modifier = Modifier.padding(end = 16.dp)
    )
  }
}
