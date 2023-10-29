plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  id("mbahgojol.library.compose")
}

android {
  namespace = "com.mbahgojol.designsystem"
}

dependencies {
  api(compose.ui)
  api(compose.foundation)
  api(compose.material3)
  api(compose.animation)
  api(libs.androidx.activity.compose)
  api(libs.constraintlayout.compose)

  implementation(projects.common.resources)
}
