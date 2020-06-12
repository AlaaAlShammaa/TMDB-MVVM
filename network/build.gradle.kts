import java.lang.System.getProperty

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
        buildConfigField("String", "TMDB_API_KEY", "\"${getProperty("local.properties", "tmdb_api_key")}\"")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // module dependencies
    implementation(project(":entity"))

    // kotlin
    implementation(Config.Libs.Kotlin.common)

    // network
    api(Config.Libs.Misc.retrofit)
    api(Config.Libs.Misc.loggingInterceptor)
    testImplementation(Config.Libs.Misc.mockwebserver)

    // unit test
    Config.Libs.Misc.unitTesting.forEach { testImplementation(it) }
}