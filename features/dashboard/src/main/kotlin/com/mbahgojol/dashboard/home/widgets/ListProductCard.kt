package com.mbahgojol.dashboard.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.mbahgojol.designsystem.GreenDark
import com.mbahgojol.designsystem.GreenLight
import com.mbahgojol.designsystem.Orange
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun ListProductCard(
  modifier: Modifier = Modifier,
) {
  val categories = listOf(
    stringResource(R.string.all_product),
    stringResource(R.string.health_services),
    stringResource(R.string.health_tools),
  )

  Column(
    modifier.fillMaxWidth()
      .padding(bottom = 16.dp), verticalArrangement = Arrangement.spacedBy(24.dp)
  ) {
    LazyRow(
      Modifier.fillMaxWidth(),
      contentPadding = PaddingValues(start = 16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      items(categories.size) {
        if (it == 0) {
          ItemCategory(categories[it], true)
        } else {
          ItemCategory(categories[it], false)
        }
      }
    }

    LazyRow(
      Modifier.fillMaxWidth(),
      contentPadding = PaddingValues(start = 16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      items(3) {
        ItemProduct()
      }
    }
  }
}

@Composable
fun ItemCategory(
  text: String,
  selected: Boolean = true,
) {
  Card(
    modifier = Modifier.wrapContentSize(),
    shape = RoundedCornerShape(30.dp),
    colors = CardDefaults.cardColors(
      containerColor = if (selected) {
        appColorScheme.primary
      } else {
        Color.White
      },
    ),
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
  ) {
    Box(contentAlignment = Alignment.Center) {
      Text(
        text, style = appTypography.labelSmall.copy(
          fontWeight = FontWeight.W700,
          lineHeight = 16.sp,
          color = if (selected) Color.White else appColorScheme.primary
        ), modifier = Modifier.padding(vertical = 7.dp, horizontal = 25.dp)
      )
    }
  }
}

@Composable
fun ItemProduct() {
  Card(
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White)
  ) {
    Box(
      modifier = Modifier.wrapContentSize()
        .padding(10.dp)
    ) {
      ItemStart(5, modifier = Modifier.align(Alignment.TopEnd))
      Column {
        Image(
          painterResource(R.drawable.img_telescope), null,
          modifier = Modifier.size(100.dp)
            .padding(10.dp)
            .align(Alignment.CenterHorizontally)
        )
        Row(
          Modifier
            .padding(top = 12.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Bottom
        ) {
          Column {
            Text(
              "Suntik Steril",
              style = appTypography.bodyMedium.copy(
                fontWeight = FontWeight.W600,
                lineHeight = 17.sp,
                color = appColorScheme.primary
              )
            )
            AppSpacer(height = 8.dp)
            Text(
              "Rp. 10.000",
              style = appTypography.labelSmall.copy(
                color = Orange,
                fontWeight = FontWeight.W600,
              )
            )
          }
          Text(
            "Ready Stok", style = appTypography.labelSmall.copy(
              fontSize = 10.sp,
              color = GreenDark,
            ),
            modifier = Modifier
              .padding(start = 4.dp)
              .background(
                color = GreenLight,
                shape = RoundedCornerShape(4.dp)
              )
              .padding(horizontal = 5.dp, vertical = 3.dp)
          )
        }
      }
    }
  }
}

@Composable
fun ItemStart(ranting: Int, modifier: Modifier = Modifier) {
  Row(modifier.wrapContentSize()) {
    Icon(
      painterResource(R.drawable.ic_start), null,
      tint = Color(0xFFFFEA00)
    )
    AppSpacer(width = 4.dp)
    Text(
      ranting.toString(),
      style = appTypography.labelLarge.copy(
        fontWeight = FontWeight.W600,
      ),
    )
  }
}
