plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  id("mbahgojol.library.compose")
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.mbahgojol.account"
}

dependencies {
  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)
  implementation(libs.koin.annotations)
  ksp(libs.koin.compiler)

  implementation(projects.core.navigation)
  implementation(projects.core.designsystem)
  implementation(projects.core.base)
  implementation(projects.common.resources)
}
