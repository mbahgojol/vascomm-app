@file:Suppress("UnstableApiUsage")

plugins {
    id("mbahgojol.application")
    id("mbahgojol.kotlin.android")
    id("mbahgojol.library.compose")
}

android {
    namespace = "com.mbahgojol.movies"

    defaultConfig {
        applicationId = "com.mbahgojol.movies"
    }

    buildFeatures {
        buildConfig = true
    }

    lint {
        baseline = file("lint-baseline.xml")
        checkReleaseBuilds = false
        ignoreTestSources = true
        abortOnError = true
    }

    packaging {
        resources.excludes += setOf(
            // Exclude AndroidX version files
            "META-INF/*.version",
            // Exclude consumer proguard files
            "META-INF/proguard/*",
            // Exclude the Firebase/Fabric/other random properties files
            "/*.properties",
            "fabric/*.properties",
            "META-INF/*.properties",
            // License files
            "LICENSE*",
            // Exclude Kotlin unused files
            "META-INF/**/previous-compilation-data.bin",
        )
    }

}

dependencies {
    implementation(compose.foundation)
    implementation(compose.material)
    implementation(compose.material3)

    implementation(libs.kotlin.coroutines.android)
    implementation(libs.androidx.activity.activity)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
}
