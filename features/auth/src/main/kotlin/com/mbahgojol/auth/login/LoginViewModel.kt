package com.mbahgojol.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbahgojol.domain.LoginByEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel(
  private val loginByEmail: LoginByEmail,
) : ViewModel() {

  private val _state: MutableStateFlow<LoginState> =
    MutableStateFlow(LoginState.initial())
  val state: StateFlow<LoginState> = _state.asStateFlow()

  fun sendEvent(event: LoginEvent) {
    when (event) {
      is LoginEvent.ChangeEmail -> _state.update {
        it.copy(
          email = event.email,
          result = null,
        )
      }

      is LoginEvent.ChangePassword -> _state.update {
        it.copy(
          password = event.password,
          result = null,
        )
      }

      LoginEvent.Login -> login()
    }
  }

  private fun login() = with(_state.value) {
    _state.update {
      it.copy(
        processing = true,
        result = null,
      )
    }

    val param = LoginByEmail.Params(email, password)
    viewModelScope.launch {
      val result = loginByEmail(param)

      _state.update {
        it.copy(
          processing = false,
          result = result
        )
      }
    }
  }
}
