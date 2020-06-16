import kotlin.reflect.full.memberProperties

object Config {
    private const val kotlinVersion = "1.3.72"
    private const val navigationVersion = "2.3.0-rc01"

    object SdkVersions {
        const val compile = 29
        const val target = 29
        const val min = 21
    }

    object AppVersions {
        const val versionCode = 1
        const val versionName = "1.0.0"
    }

    object Plugins {
        const val android = "com.android.tools.build:gradle:4.0.0"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val koin = "org.koin:koin-gradle-plugin:2.1.6"

        const val google = "com.google.gms:google-services:4.3.3"
        const val firebase = "com.google.firebase:perf-plugin:1.3.1"
        const val fabric = "io.fabric.tools:gradle:1.31.2"

        const val ktlint = "com.pinterest:ktlint:0.33.0"

        const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"

    }

    object Libs {
        object Kotlin {
            private const val coroutinesVersion = "1.3.4"

            const val common = "org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion"
            const val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
            const val js = "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion"
            const val coroutinesAndroid =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
            const val coroutinesTasks =
                "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
            const val coroutinesJs =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion"
        }

        object Jetpack {
            const val core = "androidx.core:core-ktx:1.3.0-alpha02"
            const val multidex = "androidx.multidex:multidex:2.0.1"
            const val appCompat = "androidx.appcompat:appcompat:1.2.0-alpha03"
            const val fragment = "androidx.fragment:fragment-ktx:1.3.0-alpha01"
            const val rv = "androidx.recyclerview:recyclerview:1.2.0-alpha01"
            const val rvSelection = "androidx.recyclerview:recyclerview-selection:1.1.0-rc01"
            const val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
            const val cardView = "androidx.cardview:cardview:1.0.0"
            const val palette = "androidx.palette:palette-ktx:1.0.0"
            const val emoji = "androidx.emoji:emoji-appcompat:1.1.0-alpha01"
            const val browser = "androidx.browser:browser:1.3.0-alpha01"
            const val pref = "androidx.preference:preference-ktx:1.1.0"
            const val room = "androidx.room:room-runtime:2.2.5"
            const val roomKtx = "androidx.room:room-ktx:2.2.5"
            const val roomCompiler = "androidx.room:room-compiler:2.2.5"

            const val material = "com.google.android.material:material:1.2.0-alpha05"

            val navigation by lazy {
                listOf(
                    "androidx.navigation:navigation-fragment-ktx:$navigationVersion",
                    "androidx.navigation:navigation-ui-ktx:$navigationVersion"
                )
            }

            val lifecycle by lazy {
                val version = "2.3.0-alpha01"
                listOf(
                    "androidx.lifecycle:lifecycle-common-java8:$version",
                    "androidx.lifecycle:lifecycle-process:$version",
                    "androidx.lifecycle:lifecycle-livedata-ktx:$version",
                    "androidx.lifecycle:lifecycle-viewmodel-ktx:$version",
                    "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
                )
            }

            val roomTesting by lazy {
                val version = "2.2.5"
                listOf(
                    "androidx.room:room-testing:$version"
                )
            }

            val work by lazy {
                val version = "2.4.0-alpha01"
                listOf(
                    "androidx.work:work-runtime-ktx:$version",
                    "androidx.work:work-gcm:$version"
                )
            }
        }

        object Firebase {
            const val analytics = "com.google.firebase:firebase-analytics:17.2.3"
            const val auth = "com.google.firebase:firebase-auth:19.3.0"
            const val firestore = "com.google.firebase:firebase-firestore-ktx:21.4.0"
            const val functions = "com.google.firebase:firebase-functions-ktx:19.0.2"
            const val storage = "com.google.firebase:firebase-storage-ktx:19.1.1"
            const val config = "com.google.firebase:firebase-config-ktx:19.1.2"
            const val indexing = "com.google.firebase:firebase-appindexing:19.1.0"
            const val messaging = "com.google.firebase:firebase-messaging:20.1.2"
            const val links = "com.google.firebase:firebase-dynamic-links-ktx:19.1.0"
            const val perf = "com.google.firebase:firebase-perf:19.0.5"

            const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.10.1"
        }

        object PlayServices {
            const val auth = "com.google.android.gms:play-services-auth:17.0.0"
            const val nearby = "com.google.android.gms:play-services-nearby:17.0.0"
            const val playCore = "com.google.android.play:core-ktx:1.7.0"
        }

        object FirebaseUi {
            private const val version = "aa7a585303"

            const val firestore =
                "com.github.SUPERCILEX.FirebaseUI-Android:firebase-ui-firestore:$version"
            const val auth = "com.github.SUPERCILEX.FirebaseUI-Android:firebase-ui-auth:$version"
            const val facebook = "com.facebook.android:facebook-login:5.13.0"
            const val twitter = "com.twitter.sdk.android:twitter-core:3.3.0@aar"
        }

        object Misc {
            private const val retrofitVersion = "2.6.4"
            private const val poiVersion = "3.17"

            private const val glideVersion = "4.11.0"

            const val junitVersion = "4.12"
            const val androidxTest = "1.1.0"
            const val unitTestCoreVersion = "1.2.0"
            const val robolectricVersion = "4.3"
            const val androidxTestRules = "1.2.0-alpha04"
            const val mockWebServerVersion = "3.9.0"
            const val mockitoKotlinVersion = "2.1.0"
            const val archCompomentVersion = "2.0.0"
            const val okhttpVersion = "4.1.0"
            const val moshiVersion = "1.9.2"
            const val koinVersion = "2.1.6"

            const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.2"
            const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
            const val mockwebserver = "com.squareup.okhttp3:mockwebserver:$okhttpVersion"
            const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
            const val gson = "com.google.code.gson:gson:2.8.6"

            const val glide = "com.github.bumptech.glide:glide:$glideVersion"
            const val glideRv = "com.github.bumptech.glide:recyclerview-integration:$glideVersion"
            const val flexbox = "com.google.android:flexbox:2.0.1"
            const val snap = "com.github.rubensousa:gravitysnaphelper:2.2.0"
            const val permissions = "pub.devrel:easypermissions:3.0.0"
            const val mttp = "uk.co.samuelwall:material-tap-target-prompt:3.0.0"
            const val licenses = "net.yslibrary.licenseadapter:licenseadapter:3.0.0"
            const val moshi = "com.squareup.moshi:moshi-kotlin:1.9.2"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:2.9.0"
            const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:1.9.2"
            const val timber = "com.jakewharton.timber:timber:4.7.1"
            val smoothBottomBar = "com.github.ibrahimsn98:SmoothBottomBar:1.7.6"

            val koin by lazy {
                listOf(
                    "org.koin:koin-androidx-scope:$koinVersion",
                    "org.koin:koin-androidx-viewmodel:$koinVersion",
                    "org.koin:koin-androidx-fragment:$koinVersion",
                    "org.koin:koin-androidx-ext:$koinVersion"
                )
            }

            val unitTesting by lazy {
                listOf(
                    "junit:junit:$junitVersion",
                    "androidx.test:core:$androidxTest",
                    "org.robolectric:robolectric:$robolectricVersion",
                    "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion",
                    "androidx.arch.core:core-testing:$archCompomentVersion"
                )
            }

        }
    }
}
