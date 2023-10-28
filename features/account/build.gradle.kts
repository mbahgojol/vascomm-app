plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  id("mbahgojol.library.compose")
}

android {
  namespace = "com.mbahgojol.account"
}

dependencies {
  implementation(compose.foundation)
  implementation(compose.material)
  implementation(compose.material3)
  implementation(compose.animation)
}
