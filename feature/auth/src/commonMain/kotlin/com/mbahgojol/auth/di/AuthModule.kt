package com.mbahgojol.auth.di

import com.mbahgojol.auth.Greeting
import org.koin.dsl.module

val authModule = module {
  single { Greeting() }
}
