plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.SdkVersions.compile)
    defaultConfig {
        applicationId = "com.alaashammaa.tmdbmvvm"
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

    buildFeatures {
        dataBinding = true
    }
    lintOptions {
        isAbortOnError = false
        isIgnoreWarnings = true
        isQuiet = true
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_BASE", "\"http://www.mocky.io/v2/\"")
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
        }
        getByName("release") {
            buildConfigField("String", "API_BASE", "\"http://www.mocky.io/v2/\"")
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            isZipAlignEnabled = true
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(project(":entity"))
    implementation(project(":network"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Config.Libs.Jetpack.material)
    implementation(Config.Libs.Jetpack.appCompat)
    implementation(Config.Libs.Jetpack.cardView)
    implementation(Config.Libs.Jetpack.constraint)
    implementation(Config.Libs.Jetpack.fragment)
    implementation(Config.Libs.Jetpack.rv)
    Config.Libs.Jetpack.lifecycle.forEach { implementation(it) }


    implementation(Config.Libs.Kotlin.common)
    implementation(Config.Libs.Kotlin.coroutinesAndroid)


    implementation(Config.Libs.Misc.glide)
    implementation(Config.Libs.Misc.glideRv)


}