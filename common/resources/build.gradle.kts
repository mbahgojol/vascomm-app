import com.mbahgojol.convention.commonMain

plugins {
  id("mbahgojol.kotlin.multiplatform")
  id("mbahgojol.library.compose")
}

kotlin {
  commonMain {
    dependencies {
      implementation(compose.foundation)
      implementation(compose.material)
      implementation(compose.material3)
      implementation(compose.animation)
    }
  }
}
