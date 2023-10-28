import com.mbahgojol.convention.androidMain
import com.mbahgojol.convention.commonMain
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
  id("mbahgojol.kotlin.multiplatform")
  id("mbahgojol.library.compose")
  alias(libs.plugins.ksp)
}

@OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
kotlin {
  targets.withType<KotlinNativeTarget>().configureEach {
    binaries.withType<Framework> {
      isStatic = true
      baseName = "shared"
    }
  }

  androidMain {
    dependencies {
      implementation(libs.androidx.activity.compose)
      implementation(libs.koin.android)
    }
  }

  commonMain {
    dependencies {
      implementation(libs.koin.core)
      implementation(libs.koin.compose)

      implementation(compose.ui)
      implementation(compose.runtime)
      implementation(compose.foundation)
      implementation(compose.animation)
      implementation(compose.material)
      implementation(compose.material3)
      implementation(compose.materialIconsExtended)
      implementation(compose.components.resources)

      implementation(projects.core.base)
      implementation(projects.core.designsystem)
      implementation(projects.common.resources)

      implementation(projects.feature.auth)
      implementation(projects.feature.account)
      implementation(projects.feature.dashboard)
    }
  }
}

android {
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  sourceSets["main"].res.srcDirs("src/androidMain/res")
  sourceSets["main"].resources.srcDirs("src/commonMain/resources")
}
