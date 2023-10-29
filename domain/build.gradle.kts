plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.mbahgojol.domain"
}

dependencies {
  implementation(projects.core.base)
  implementation(projects.data.authentication)

  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)
  implementation(libs.koin.annotations)
  ksp(libs.koin.compiler)
}
