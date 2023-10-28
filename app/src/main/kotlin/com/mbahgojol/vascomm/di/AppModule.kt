package com.mbahgojol.vascomm.di

import com.mbahgojol.auth.di.AuthModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [AuthModule::class])
@ComponentScan("com.mbahgojol.vascomm")
class AppModule
