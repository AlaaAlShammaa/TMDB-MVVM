plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.SdkVersions.compile)
    defaultConfig {
        minSdkVersion(Config.SdkVersions.min)
        targetSdkVersion(Config.SdkVersions.target)
        versionCode = Config.AppVersions.versionCode
        versionName = Config.AppVersions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
    }

    (this as ExtensionAware).configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions> {
        jvmTarget = "1.8"
    }
}

dependencies {
    // module dependencies
    implementation(project(":entity"))

    // kotlin
    implementation(Config.Libs.Kotlin.common)

    implementation(Config.Libs.Misc.glide)


    implementation(Config.Libs.Jetpack.material)
    implementation(Config.Libs.Jetpack.appCompat)
    implementation(Config.Libs.Jetpack.cardView)
    implementation(Config.Libs.Jetpack.constraint)
    implementation(Config.Libs.Jetpack.fragment)
    implementation(Config.Libs.Jetpack.rv)
}