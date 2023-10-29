plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.mbahgojol.base"
}

dependencies {
  implementation(libs.timber)
  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)
  implementation(libs.koin.annotations)
  ksp(libs.koin.compiler)
}
