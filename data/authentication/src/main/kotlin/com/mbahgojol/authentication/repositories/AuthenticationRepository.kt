package com.mbahgojol.authentication.repositories

import com.mbahgojol.authentication.dtos.LoginRequest

interface AuthenticationRepository {
  suspend fun login(loginRequest: LoginRequest): String
}
