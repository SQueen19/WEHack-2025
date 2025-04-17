// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //alias(libs.plugins.android.application) apply false
    //alias(libs.plugins.kotlin.android) apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false // Replace with the latest KSP version
    id("com.android.application") version "8.9.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false

    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21"
    alias(libs.plugins.google.gms.google.services) apply false


}