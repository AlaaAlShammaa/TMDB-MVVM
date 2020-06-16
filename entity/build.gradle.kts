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

    (this as ExtensionAware).configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions> {
        jvmTarget = "1.8"
    }
}

dependencies {
    // kotlin
    implementation(Config.Libs.Kotlin.common)


    // database
    implementation(Config.Libs.Jetpack.room)
    kapt(Config.Libs.Jetpack.roomCompiler)
    Config.Libs.Jetpack.roomTesting.forEach { testImplementation(it) }

    // gson converter
//    api(Config.Libs.Misc.moshi)
    api(Config.Libs.Misc.gson)
//    kapt(Config.Libs.Misc.moshiCodeGen)

    // unit test
    Config.Libs.Misc.unitTesting.forEach { testImplementation(it) }
}