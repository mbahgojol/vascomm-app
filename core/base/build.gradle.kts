import com.mbahgojol.convention.androidMain
import com.mbahgojol.convention.commonMain

plugins {
  id("mbahgojol.kotlin.multiplatform")
  id("mbahgojol.library.compose")
}

kotlin {
  androidMain {
    dependencies {
      implementation(libs.koin.android)
    }
  }

  commonMain {
    dependencies {
      implementation(libs.koin.core)

      api(libs.mvvm.core)
      api(libs.mvvm.compose)
      api(libs.mvvm.flow)
      api(libs.mvvm.flow.compose)
    }
  }
}
