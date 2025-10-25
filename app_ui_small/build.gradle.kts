import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidLibrary {
        namespace = "tonix.app.app_ui_small"
        compileSdk = 36
        minSdk = 24
    }

    iosArm64()
    iosSimulatorArm64()
    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.library()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            /** PROJECT **/
            implementation(projects.shared)
            implementation(projects.appShared.coreUi)
            implementation(projects.appShared.ui)
            /** COMPOSE **/
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            /** DEPENDENCIES **/
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.mvi)
            implementation(libs.bundles.coil)
            implementation(libs.bundles.koin)
            implementation(libs.bundles.decompose)
        }
    }
}