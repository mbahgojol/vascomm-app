package com.mbahgojol.convention

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

val Project.libsExt
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

val VersionCatalog.compileSdkVersion
    get() = findVersion("androidCompileSdk").get().toString().toInt()

val VersionCatalog.minSdkVersion get() = findVersion("androidMinSdk").get().toString().toInt()
val VersionCatalog.targetSdkVersion get() = findVersion("androidTargetSdk").get().toString().toInt()
val VersionCatalog.versionCode get() = findVersion("versionCode").get().toString().toInt()
val VersionCatalog.versionName get() = findVersion("versionName").get().toString()
val VersionCatalog.composeCompiler get() = findVersion("compose-compiler").get().toString()

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.androidMain(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("androidMain", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.commonMain(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("commonMain", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.commonTest(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("commonTest", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.iosMain(block: KotlinSourceSet.() -> Unit) =
    sourceSets.getByName("iosMain", block)

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.cocoapods(configure: Action<CocoapodsExtension>): Unit =
    (this as ExtensionAware).extensions.configure("cocoapods", configure)
