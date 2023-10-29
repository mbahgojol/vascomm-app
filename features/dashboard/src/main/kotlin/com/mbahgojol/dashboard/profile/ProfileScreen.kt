package com.mbahgojol.dashboard.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import com.mbahgojol.dashboard.navigation.OnBackClick
import com.mbahgojol.dashboard.profile.widgets.AccountTab
import com.mbahgojol.dashboard.profile.widgets.ChoosePersonalDataCard
import com.mbahgojol.dashboard.profile.widgets.MemberCard
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppButtonWithIcon
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.designsystem.widgets.AppTextField
import com.mbahgojol.designsystem.widgets.InfoNotifCard
import com.mbahgojol.resources.R

@Composable
internal fun ProfileScreen(
  modifier: Modifier = Modifier,
) {
  ProfileUi(
    onBackClick = {},
    modifier = modifier,
  )
}

@Composable
private fun ProfileUi(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
) {
  Scaffold {
    Column(
      Modifier.padding(it)
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally
    ) {
      AppSpacer(height = 40.dp)
      AccountTab()
      AppSpacer(height = 40.dp)
      Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 50.dp),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
      ) {
        Column(
          Modifier.fillMaxWidth()
        ) {
          MemberCard()
          Column(
            Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
          ) {
            Text(
              stringResource(R.string.choose_your_data), style = appTypography.labelLarge.copy(
                fontWeight = FontWeight.W600,
                lineHeight = 20.sp,
                color = appColorScheme.primary,
              )
            )
            ChoosePersonalDataCard()
            AppTextField(
              placeholder = stringResource(R.string.input_first_name),
              label = stringResource(R.string.first_name),
              initialValue = "Jhon",
              readOnly = true,
              enable = false,
              elevation = 1.dp
            )
            AppTextField(
              placeholder = stringResource(R.string.input_last_name),
              label = stringResource(R.string.last_name),
              initialValue = "Doe",
              readOnly = true,
              enable = false,
              elevation = 1.dp
            )
            AppTextField(
              placeholder = stringResource(R.string.input_email),
              label = stringResource(R.string.email),
              readOnly = true,
              enable = false,
              elevation = 1.dp
            )
            AppTextField(
              placeholder = stringResource(R.string.input_phone_number),
              label = stringResource(R.string.phone_number),
              readOnly = true,
              enable = false,
              elevation = 1.dp
            )
            AppTextField(
              placeholder = stringResource(R.string.input_id_card),
              label = stringResource(R.string.id_card),
              readOnly = true,
              enable = false,
              elevation = 1.dp
            )
            AppSpacer(height = 16.dp)
            Row(
              Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top
            ) {
              Icon(painterResource(R.drawable.ic_info), null)
              AppSpacer(width = 16.dp)
              Text(
                stringResource(R.string.make_sure_profile_filled_correctly),
                style = appTypography.labelSmall,
                fontWeight = FontWeight.W400,
                lineHeight = 14.sp
              )
            }
            AppSpacer(height = 16.dp)
            AppButtonWithIcon(
              onClick = {},
              text = stringResource(R.string.save_profile),
              painter = painterResource(R.drawable.ic_save),
              modifier = Modifier.fillMaxWidth().height(48.dp)
            )
            AppSpacer(height = 16.dp)
          }
        }
      }
      AppSpacer(height = 40.dp)
      InfoNotifCard()
    }
  }
}
