package com.mbahgojol.auth.login

sealed class LoginEvent {
  data class ChangeEmail(val email: String) : LoginEvent()
  data class ChangePassword(val password: String) : LoginEvent()
  data object Login : LoginEvent()
}
