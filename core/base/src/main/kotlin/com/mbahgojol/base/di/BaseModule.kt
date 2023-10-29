package com.mbahgojol.base.di

import com.mbahgojol.base.AppDispatchers
import com.mbahgojol.base.AppDispatchersImpl
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.mbahgojol.base")
class BaseModule {
  @Single
  fun provideAppDispatchers(): AppDispatchers {
    return AppDispatchersImpl()
  }
}
