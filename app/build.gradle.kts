plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "2.0.21"
    id("kotlin-parcelize")

    id("kotlin-kapt")
    //id("com.google.gms.google-services") version "4.4.2" apply false
    id("org.jetbrains.kotlin.plugin.serialization")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.wehack_finances"
    compileSdk = 35
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        applicationId = "com.example.wehack_finances"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.material.v1110)
    implementation (libs.kotlin.stdlib)
    implementation (libs.androidx.core.ktx.v180)
    implementation (libs.androidx.appcompat.v142)
    implementation (libs.firebase.bom)
    implementation (libs.material.v161)
    implementation(libs.firebase.database)

    //implementation ("com.google.firebase:firebase-auth")
    //implementation ("com.google.firebase:firebase-firestore")
    implementation (libs.gson.v290)
    implementation(libs.androidx.room.runtime) // Or latest stable version
    //kapt("androidx.room:room-compiler:2.6.1") // For Kotlin Kapt (or annotationProcessor for Java)
    implementation(libs.androidx.room.ktx.v270) // For Kotlin extensions (coroutines support)
    implementation(libs.kotlinx.coroutines.android) // Or latest stable version
    implementation(libs.androidx.security.crypto)
    implementation (libs.androidx.constraintlayout)
    implementation (libs.asynchttpclient)
    implementation (libs.androidx.recyclerview)
    implementation(libs.kotlinx.serialization.json.v122)
    implementation (libs.androidx.recyclerview.selection)
    implementation (libs.glide)
    implementation (libs.google.gson)
    implementation(libs.constraintlayout.v214)
    implementation (libs.jetbrains.kotlinx.serialization.json)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime.android)
    annotationProcessor (libs.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
}
