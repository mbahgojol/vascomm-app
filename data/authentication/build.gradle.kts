plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.mbahgojol.authentication"
}

dependencies {
  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)
  implementation(libs.koin.annotations)
  ksp(libs.koin.compiler)

  implementation(libs.ktor.client.core)
  implementation(libs.ktor.client.okhttp)
  implementation(libs.ktor.client.auth)
  implementation(libs.ktor.client.cio)

  implementation(projects.data.network)
}
