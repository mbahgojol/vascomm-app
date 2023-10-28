import com.mbahgojol.convention.commonMain

plugins {
  id("mbahgojol.kotlin.multiplatform")
  id("mbahgojol.library.compose")
  alias(libs.plugins.ksp)
}

kotlin {
  commonMain {
    dependencies {
      implementation(compose.foundation)
      implementation(compose.material)
      implementation(compose.material3)
      implementation(compose.animation)

      implementation(libs.koin.core)
      implementation(libs.koin.compose)
      implementation(libs.koin.annotations)
    }
  }
}
