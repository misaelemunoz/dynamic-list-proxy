import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.mavenPublish)
    alias(libs.plugins.cocoapods)
}

mavenPublishing {
    // Define coordinates for the published artifact
    coordinates(
        groupId = "io.github.misaelemunoz",
        artifactId = "dynamiclist-proxy",
        version = "1.0.1"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("KMP Library for dynamic list proxy")
        description.set("This library can be used by Android and iOS targets for mapping dynamic list responses")
        inceptionYear.set("2024")
        url.set("https://github.com/misaelemunoz/dynamic-list-proxy")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("misaelemunoz")
                name.set("Misael Munoz")
                email.set("misael.munoz@rappi.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/misaelemunoz/dynamic-list-proxy")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }

        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.encoding)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.client.contentnegotiation)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }

    cocoapods {
        version = "1.0.1"
        summary = "iOS library for mapping dynamic list responses"
        homepage = "https://github.com/misaelemunoz/dynamic-list-proxy"
        ios.deploymentTarget = "13.0"
        source = "https://github.com/misaelemunoz/dynamic-list-proxy.git"
        framework {
            baseName = "DynamicListProxy"
            isStatic = true
        }
        noPodspec()
    }
}

android {
    namespace = "com.rappi.dynamiclist.proxy"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

version = "1.0.1"