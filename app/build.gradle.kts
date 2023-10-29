@file:Suppress("UnstableApiUsage")

plugins {
  id("mbahgojol.application")
  id("mbahgojol.kotlin.android")
  id("mbahgojol.library.compose")
  alias(libs.plugins.ksp)
}

val useReleaseKeystore = rootProject.file("release/app-release.jks").exists()

android {
  namespace = "com.mbahgojol.vascomm"

  defaultConfig {
    applicationId = "com.mbahgojol.vascomm"
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
  implementation(projects.features.auth)
  implementation(projects.features.dashboard)

  implementation(projects.core.base)
  implementation(projects.core.navigation)
  implementation(projects.core.designsystem)
  implementation(projects.domain)
  implementation(projects.data.network)
  implementation(projects.data.authentication)

  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)
  implementation(libs.koin.annotations)
  ksp(libs.koin.compiler)

  implementation(libs.kotlin.coroutines.android)
  implementation(libs.androidx.activity.activity)
  implementation(libs.timber)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.junit)
}

ksp {
  arg("KOIN_CONFIG_CHECK","true")
}

ksp {
  arg("KOIN_DEFAULT_MODULE","false")
}


fun DependencyHandler.qaImplementation(dependencyNotation: Any) =
  add("qaImplementation", dependencyNotation)

fun DependencyHandler.standardImplementation(dependencyNotation: Any) =
  add("standardImplementation", dependencyNotation)
