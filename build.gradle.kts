// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Config.Plugins.android)
        classpath(Config.Plugins.kotlin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}