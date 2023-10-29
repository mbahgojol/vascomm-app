package com.mbahgojol.domain

import com.mbahgojol.authentication.dtos.LoginRequest
import com.mbahgojol.authentication.repositories.AuthenticationRepository
import com.mbahgojol.base.AppDispatchers
import com.mbahgojol.base.dispatcherOn
import com.mbahgojol.base.suspendRunCatching
import org.koin.core.annotation.Single

@Single
class LoginByEmail(
  private val authRepository: AuthenticationRepository,
  private val dispatchers: AppDispatchers,
) {
  suspend operator fun invoke(params: Params): Result<String> {
    val request = LoginRequest(params.email, params.password)
    return suspendRunCatching {
      authRepository.login(request)
    }.dispatcherOn(dispatchers.io)
  }

  data class Params(
    val email: String,
    val password: String,
  )
}
