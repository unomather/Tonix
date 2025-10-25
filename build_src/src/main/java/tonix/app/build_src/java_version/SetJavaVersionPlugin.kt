package tonix.app.build_src.java_version

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class SetJavaVersionPlugin: Plugin<Project> {
    override fun apply(rootProject: Project) = rootProject.subprojects {
        configureKotlinMultiplatform()
        configureAndroidApplication()
        configureAndroidLibrary()
        configureJava()
    }

    private fun Project.configureKotlinMultiplatform() {
        plugins.withId("org.jetbrains.kotlin.multiplatform") {
            extensions.configure<KotlinMultiplatformExtension> {
                jvmToolchain(JVM_TOOLCHAIN_VERSION)
            }
        }
    }

    private fun Project.configureAndroidApplication() = plugins.withId("com.android.application") {
        extensions.configure<ApplicationExtension> {
            compileOptions {
                sourceCompatibility = JAVA_VERSION
                targetCompatibility = JAVA_VERSION
            }
        }
    }

    private fun Project.configureAndroidLibrary() = plugins.withId("com.android.library") {
        extensions.configure<LibraryExtension> {
            compileOptions {
                sourceCompatibility = JAVA_VERSION
                targetCompatibility = JAVA_VERSION
            }
        }
    }

    private fun Project.configureJava() = plugins.withId("java") {
        extensions.configure<JavaPluginExtension> {
            sourceCompatibility = JAVA_VERSION
            targetCompatibility = JAVA_VERSION
            toolchain {
                languageVersion.set(JAVA_LANGUAGE_VERSION)
            }
        }
    }

    private companion object {
        const val JVM_TOOLCHAIN_VERSION = 21
        val JAVA_LANGUAGE_VERSION = JavaLanguageVersion.of(JVM_TOOLCHAIN_VERSION)
        val JAVA_VERSION = JavaVersion.toVersion(JVM_TOOLCHAIN_VERSION)
    }
}
