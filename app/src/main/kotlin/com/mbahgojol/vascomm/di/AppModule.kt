package com.mbahgojol.vascomm.di

import com.mbahgojol.auth.di.AuthModule
import com.mbahgojol.authentication.di.AuthenticationModule
import com.mbahgojol.base.di.BaseModule
import com.mbahgojol.domain.di.DomainModule
import com.mbahgojol.network.AppHttpClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
  includes = [
    AuthModule::class,
    BaseModule::class,
    AppHttpClient::class,
    AuthenticationModule::class,
    DomainModule::class,
  ]
)
@ComponentScan("com.mbahgojol.vascomm")
class AppModule
