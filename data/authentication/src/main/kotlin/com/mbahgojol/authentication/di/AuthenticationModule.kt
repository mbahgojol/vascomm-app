package com.mbahgojol.authentication.di

import com.mbahgojol.authentication.datasources.AuthenticationDataSources
import com.mbahgojol.authentication.repositories.AuthenticationRepository
import com.mbahgojol.authentication.repositories.AuthenticationRepositoryImpl
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.mbahgojol.authentication")
class AuthenticationModule {
  @Single
  fun provideAuthenticationRepository(dataSources: AuthenticationDataSources): AuthenticationRepository {
    return AuthenticationRepositoryImpl(dataSources)
  }
}
