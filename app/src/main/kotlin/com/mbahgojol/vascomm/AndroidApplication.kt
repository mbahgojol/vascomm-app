package com.mbahgojol.vascomm

import android.app.Application
import com.mbahgojol.vascomm.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import timber.log.Timber

class AndroidApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }

    startKoin {
      androidContext(this@AndroidApplication)
      androidLogger()
      modules(AppModule().module)
    }
  }
}
