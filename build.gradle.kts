import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.publish)
}

repositories {
    google()
    mavenCentral()
}

val artifactId: String by project
val xcf = XCFramework(artifactId)

kotlin {
    jvmToolchain(11)
    jvm()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        macosX64(),
        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = artifactId

            // Specify CFBundleIdentifier to uniquely identify the framework
            binaryOption("bundleId", "com.solanamobile.${artifactId}")
            xcf.add(this)
            isStatic = true
        }
    }
    js {
        browser()
        nodejs()
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.multimult)
            }
        }
    }
}

mavenPublishing {
    coordinates(group as String, artifactId, version as String)
}
