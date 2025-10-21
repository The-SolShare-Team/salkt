plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.publish)
}

repositories {
    google()
    mavenCentral()
}

val artifactId: String by project

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
