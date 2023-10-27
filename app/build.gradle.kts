@file:Suppress("UnstableApiUsage")

plugins {
  id("mbahgojol.application")
  id("mbahgojol.kotlin.android")
  id("mbahgojol.library.compose")
}

val useReleaseKeystore = rootProject.file("release/app-release.jks").exists()

android {
  namespace = "com.mbahgojol.movies"

  defaultConfig {
    applicationId = "com.mbahgojol.movies"
  }

  buildFeatures {
    buildConfig = true
  }

  signingConfigs {
    getByName("debug") {
      storeFile = rootProject.file("release/app-debug.jks")
      storePassword = "android"
      keyAlias = "androiddebugkey"
      keyPassword = "android"
    }

    create("release") {
      if (useReleaseKeystore) {
        storeFile = rootProject.file("release/app-release.jks")
        storePassword = properties["APP_RELEASE_KEYSTORE_PWD"]?.toString() ?: ""
        keyAlias = "app"
        keyPassword = properties["APP_RELEASE_KEY_PWD"]?.toString() ?: ""
      }
    }
  }

  lint {
    baseline = file("lint-baseline.xml")
    checkReleaseBuilds = false
    ignoreTestSources = true
    abortOnError = true
  }

  buildTypes {
    debug {
      signingConfig = signingConfigs["debug"]
      versionNameSuffix = "-dev"
      applicationIdSuffix = ".debug"
    }

    release {
      signingConfig = signingConfigs[if (useReleaseKeystore) "release" else "debug"]
      isShrinkResources = true
      isMinifyEnabled = true
      proguardFiles("proguard-rules.pro")
    }

    create("benchmark") {
      initWith(buildTypes["release"])
      signingConfig = signingConfigs["debug"]
      matchingFallbacks += "release"
      proguardFiles("benchmark-rules.pro")
    }
  }

  flavorDimensions += "mode"
  productFlavors {
    create("qa") {
      dimension = "mode"
      // This is a build with Chucker enabled
      proguardFiles("proguard-rules-chucker.pro")
      versionNameSuffix = "-qa"
    }

    create("standard") {
      dimension = "mode"
      // Standard build is always ahead of the QA builds as it goes straight to
      // the alpha channel. This is the 'release' flavour
      versionCode = (android.defaultConfig.versionCode ?: 0) + 1
    }
  }

}

dependencies {
  qaImplementation(projects.shared)
  standardImplementation(projects.shared)

  implementation(compose.foundation)
  implementation(compose.material)
  implementation(compose.material3)

  implementation(libs.kotlin.coroutines.android)
  implementation(libs.androidx.activity.activity)
  implementation(libs.androidx.activity.compose)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.junit)
}


fun DependencyHandler.qaImplementation(dependencyNotation: Any) =
  add("qaImplementation", dependencyNotation)

fun DependencyHandler.standardImplementation(dependencyNotation: Any) =
  add("standardImplementation", dependencyNotation)
