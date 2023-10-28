package com.mbahgojol.auth.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.auth.navigation.OnClickUnit
import com.mbahgojol.designsystem.GilroyFamily
import com.mbahgojol.designsystem.utils.appColorScheme
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.resources.R

@Composable
fun AppPasswordTextField(
  label: String = stringResource(R.string.password),
  onClickForgotPassword: OnClickUnit? = null,
) {
  Column {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(
        label, style = appTypography.labelLarge.copy(
          fontWeight = FontWeight.W600, color = appColorScheme.primary, fontFamily = GilroyFamily
        ), modifier = Modifier.padding(horizontal = 16.dp)
      )
      if (onClickForgotPassword != null)
        Text(
          stringResource(R.string.forgot_password), style = appTypography.labelMedium.copy(
            fontWeight = FontWeight.W600,
            lineHeight = 18.sp,
          ), modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
    AppSpacer(height = 16.dp)
    PasswordTextField(
      modifier = Modifier.padding(horizontal = 16.dp),
      placeholder = stringResource(R.string.input_password),
    )
  }
}
