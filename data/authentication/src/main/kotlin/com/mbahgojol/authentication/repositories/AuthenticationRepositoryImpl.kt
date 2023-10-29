package com.mbahgojol.authentication.repositories

import com.mbahgojol.authentication.datasources.AuthenticationDataSources
import com.mbahgojol.authentication.dtos.LoginRequest

internal class AuthenticationRepositoryImpl(
  private val dataSources: AuthenticationDataSources,
) : AuthenticationRepository {
  override suspend fun login(loginRequest: LoginRequest): String {
    return dataSources.login(loginRequest)
  }
}
