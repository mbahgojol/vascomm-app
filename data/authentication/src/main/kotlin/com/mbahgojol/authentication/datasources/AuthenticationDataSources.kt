package com.mbahgojol.authentication.datasources

import com.mbahgojol.authentication.dtos.LoginRequest
import com.mbahgojol.network.safeRequest
import com.mbahgojol.network.toJson
import com.mbahgojol.network.toJsonObject
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import org.koin.core.annotation.Single

@Single
class AuthenticationDataSources(
  private val client: HttpClient,
) {
  suspend fun login(loginRequest: LoginRequest): String {
    return safeRequest {
      val response = client.post("api/login") {
        setBody(loginRequest.toJson())
      }
      val jsonObject = response.toJsonObject()
      jsonObject.getString("token")
    }
  }
}
