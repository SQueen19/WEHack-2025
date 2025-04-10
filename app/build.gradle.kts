plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    //id("com.google.gms.google-services") version "4.4.2" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.wehack_finances"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11 // Or higher if needed
        targetCompatibility = JavaVersion.VERSION_11 // Or higher

    }

    // Enable desugaring if you're using Java 8+ features

    defaultConfig {
        applicationId = "com.example.wehack_finances"
        minSdk = 24
        targetSdk = 34
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
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
    implementation ("androidx.core:core-ktx:1.8.0")
    implementation ("androidx.appcompat:appcompat:1.4.2")
    implementation ("com.google.firebase:firebase-bom:33.12.0")
    implementation ("com.google.android.material:material:1.6.1")
    implementation(libs.firebase.database)

    //implementation ("com.google.firebase:firebase-auth")
    //implementation ("com.google.firebase:firebase-firestore")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation("androidx.room:room-runtime:2.6.1") // Or latest stable version
    //kapt("androidx.room:room-compiler:2.6.1") // For Kotlin Kapt (or annotationProcessor for Java)
    implementation("androidx.room:room-ktx:2.6.1") // For Kotlin extensions (coroutines support)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Or latest stable version
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.codepath.libraries:asynchttpclient:2.2.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
