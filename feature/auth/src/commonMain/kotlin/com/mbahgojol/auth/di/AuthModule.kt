package di

import Greeting
import org.koin.dsl.module

val authModule = module {
  single { Greeting() }
}
