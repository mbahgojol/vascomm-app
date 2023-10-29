@file:Suppress("unused")

package com.mbahgojol.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.mbahgojol.base.exceptions.HttpError
import com.mbahgojol.base.exceptions.HttpErrorBadRequest
import com.mbahgojol.base.exceptions.HttpErrorConnectionTimeout
import com.mbahgojol.base.exceptions.HttpErrorForbidden
import com.mbahgojol.base.exceptions.HttpErrorInternalServerError
import com.mbahgojol.base.exceptions.HttpErrorNotFound
import com.mbahgojol.base.exceptions.HttpErrorRedirect
import com.mbahgojol.base.exceptions.HttpErrorUnauthorized
import com.mbahgojol.base.exceptions.toHttpErrorResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.mbahgojol.authentication")
class AppHttpClient {

  @Single
  fun provideHttpClient(
    context: Context,
  ): HttpClient = HttpClient(OkHttp) {
    engine {
      clientCacheSize = 10 * 1024 * 1024
      config {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
          setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        addInterceptor(
          ChuckerInterceptor.Builder(context).build(),
        )
        addInterceptor(loggingInterceptor)

        readTimeout(25, TimeUnit.SECONDS)
        connectTimeout(60, TimeUnit.SECONDS)
        writeTimeout(300, TimeUnit.SECONDS)
      }
    }

    expectSuccess = true

    addDefaultResponseValidation()

    HttpResponseValidator {
      handleResponseExceptionWithRequest { cause, _ ->
        throw cause.toHttpErrorExceptions()
      }
    }

    install(DefaultRequest) {
      url("https://reqres.in/")
      header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
  }
}

suspend fun Throwable.toHttpErrorExceptions() = when (this) {
  is ServerResponseException -> HttpErrorInternalServerError()
  is RedirectResponseException -> HttpErrorRedirect()
  is ConnectTimeoutException -> HttpErrorConnectionTimeout()
  is ClientRequestException -> {
    val httpErrorResponse = response.bodyAsText().toHttpErrorResponse()
    when (response.status) {
      HttpStatusCode.BadRequest -> HttpErrorBadRequest(httpErrorResponse)
      HttpStatusCode.Unauthorized -> HttpErrorUnauthorized(httpErrorResponse)
      HttpStatusCode.Forbidden -> HttpErrorForbidden(httpErrorResponse)
      HttpStatusCode.NotFound -> HttpErrorNotFound(httpErrorResponse)
      else -> HttpError(httpErrorResponse)
    }
  }

  else -> this
}
