plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  id("mbahgojol.library.compose")
}

android {
  namespace = "com.mbahgojol.navigation"
}

dependencies {
  api(libs.androidx.navigation.compose)
  api(libs.androidx.navigation.runtime)
  api(libs.androidx.core)
  implementation(projects.core.designsystem)
}
