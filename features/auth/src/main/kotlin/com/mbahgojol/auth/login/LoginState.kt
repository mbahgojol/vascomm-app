package com.mbahgojol.auth.login

data class LoginState(
  val email: String,
  val password: String,
  val processing: Boolean,
  val result: Result<String>?,
) {
  companion object {
    fun initial(): LoginState {
      return LoginState(
        processing = false, result = null,
        email = "",
        password = ""
      )
    }
  }
}
