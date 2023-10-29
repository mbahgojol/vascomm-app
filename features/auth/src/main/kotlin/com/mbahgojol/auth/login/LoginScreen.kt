package com.mbahgojol.auth.login

import android.widget.Toast
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mbahgojol.auth.login.widgets.SignUpLinkButton
import com.mbahgojol.auth.navigation.OnBackClick
import com.mbahgojol.auth.utils.SnackBarState
import com.mbahgojol.auth.utils.rememberSnackBarState
import com.mbahgojol.auth.widgets.AppPasswordTextField
import com.mbahgojol.auth.widgets.LoadingDialog
import com.mbahgojol.base.exceptions.toErrorState
import com.mbahgojol.designsystem.utils.appTypography
import com.mbahgojol.designsystem.widgets.AppButtonWithIcon
import com.mbahgojol.designsystem.widgets.AppSpacer
import com.mbahgojol.designsystem.widgets.AppTextField
import com.mbahgojol.designsystem.widgets.BoldTextAtEnd
import com.mbahgojol.navigation.AppDestinations
import com.mbahgojol.navigation.LocalNavigator
import com.mbahgojol.navigation.goTo
import com.mbahgojol.resources.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier,
  viewModel: LoginViewModel = koinViewModel(),
) {
  val navigator = LocalNavigator.current
  val state by viewModel.state.collectAsStateWithLifecycle()
  val context = LocalContext.current
  val snackBarState = rememberSnackBarState()

  if (state.processing) {
    LoadingDialog()
  }

  state.result?.onSuccess {
    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
    navigator.navigate(AppDestinations.Dashboard.name) {
      popUpTo(AppDestinations.Login.name) {
        inclusive = true
      }
    }
  }

  state.result?.onFailure {
    val errorState = it.toErrorState()
    snackBarState.showSnackBar(errorState.message)
  }

  LoginUi(onClickLogin = {
    viewModel.sendEvent(LoginEvent.Login)
  }, onClickRegister = {
    navigator.goTo(AppDestinations.Register)
  }, viewModel = viewModel,
    snackBarState = snackBarState
  )
}

@Composable
private fun LoginUi(
  onClickLogin: OnBackClick,
  onClickRegister: OnBackClick,
  viewModel: LoginViewModel,
  snackBarState: SnackBarState,
  scrollState: ScrollState = rememberScrollState(),
) {
  Scaffold(snackbarHost = {
    snackBarState.SnackBarHost()
  }) {
    Column(
      Modifier.padding(it)
        .fillMaxSize()
        .statusBarsPadding()
        .navigationBarsPadding()
        .imePadding()
        .verticalScroll(scrollState)
        .padding(
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
      AppTextField(modifier = Modifier.padding(horizontal = 16.dp),
        placeholder = stringResource(R.string.input_email),
        label = stringResource(R.string.email),
        onValueChange = {
          viewModel.sendEvent(LoginEvent.ChangeEmail(it))
        })
      AppSpacer(
        height = 40.dp
      )
      AppPasswordTextField(onClickForgotPassword = {

      }, onValueChange = {
        viewModel.sendEvent(LoginEvent.ChangePassword(it))
      })
      AppSpacer(height = 40.dp)
      AppButtonWithIcon(
        modifier = Modifier.fillMaxWidth().height(48.dp).padding(horizontal = 16.dp),
        onClick = onClickLogin,
        text = stringResource(R.string.login),
      )
      AppSpacer(height = 30.dp)
      SignUpLinkButton(modifier = Modifier.align(Alignment.CenterHorizontally), onClickRegister)
    }
  }
}
