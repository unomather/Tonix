import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeHotReload)
}

kotlin {
    androidLibrary {
        namespace = "tonix.app.app_shared.core_ui"
        compileSdk = 36
        minSdk = 24
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
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
        commonMain.dependencies {
            /** PROJECT **/
            implementation(projects.shared)
            /** COMPOSE **/
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            /** DEPENDENCIES **/
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.coil)
            implementation(libs.bundles.koin)
            implementation(libs.bundles.mvi)
            implementation(libs.bundles.decompose)
            implementation(libs.bundles.ui)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "tonix.app.resources"
    generateResClass = always
}