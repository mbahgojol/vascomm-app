package com.mbahgojol.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahgojol.auth.login.widgets.SignUpLinkButton
import com.mbahgojol.auth.navigation.OnBackClick
import com.mbahgojol.auth.widgets.AppPasswordTextField
import com.mbahgojol.base.navigator.LocalNavigator
import com.mbahgojol.base.navigator.goTo
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppButtonWithIcon
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.designsystem.widgets.AppTextField
import com.mbahgojol.designsystem.widgets.BoldTextAtEnd
import com.mbahgojol.navigation.AppDestinations
import com.mbahgojol.resources.R

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier,
) {
  LoginUi(
    onBackClick = {},
    modifier = modifier,
  )
}

@Composable
private fun LoginUi(
  onBackClick: OnBackClick,
  modifier: Modifier = Modifier,
  state: ScrollState = rememberScrollState(),
) {
  val navigator = LocalNavigator.current

  Column(
    Modifier.fillMaxSize()
      .statusBarsPadding()
      .navigationBarsPadding()
      .imePadding()
      .verticalScroll(state).padding(
        top = 50.dp,
        bottom = 50.dp,
      ),
  ) {
    BoldTextAtEnd(
      text = stringResource(R.string.welcome), modifier = Modifier.padding(
        horizontal = 16.dp
      )
    )
    AppSpacer(height = 4.dp)
    Text(
      stringResource(R.string.please_login),
      style = appTypography.labelSmall.copy(
        lineHeight = 16.sp, fontWeight = FontWeight.W600
      ),
      modifier = Modifier.padding(
        horizontal = 16.dp
      ),
    )
    Image(
      painterResource(R.drawable.img_login),
      null,
      modifier = Modifier.align(Alignment.End).height(250.dp),
      alignment = Alignment.TopEnd,
      contentScale = ContentScale.Crop
    )
    AppSpacer(
      height = 16.dp
    )
    AppTextField(
      modifier = Modifier.padding(horizontal = 16.dp),
      placeholder = stringResource(R.string.input_email),
      label = stringResource(R.string.email)
    )
    AppSpacer(
      height = 40.dp
    )
    AppPasswordTextField(onClickForgotPassword = {

    })
    AppSpacer(height = 40.dp)
    AppButtonWithIcon(
      modifier = Modifier.fillMaxWidth().height(48.dp).padding(horizontal = 16.dp),
      onClick = {
        navigator.goTo(AppDestinations.Dashboard)
      },
      text = stringResource(R.string.login),
    )
    AppSpacer(height = 30.dp)
    SignUpLinkButton(modifier = Modifier.align(Alignment.CenterHorizontally)) {
      navigator.goTo(AppDestinations.Register)
    }
  }
}
