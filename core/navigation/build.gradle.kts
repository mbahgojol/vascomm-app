plugins {
  id("mbahgojol.library")
  id("mbahgojol.kotlin.android")
}

android {
  namespace = "com.mbahgojol.navigation"
}

dependencies {
  implementation(projects.core.base)
}
