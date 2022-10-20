plugins {
    id("com.android.application")
    kotlin("plugin.serialization")
    kotlin("android")
}

dependencies {
    implementation("com.google.android.material:material:1.6.1")

    implementation("androidx.appcompat:appcompat:1.5.1")

    implementation("androidx.activity:activity-compose:1.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    implementation("androidx.compose.ui:ui:1.3.0-rc01")
    implementation("androidx.compose.material:material:1.3.0-rc01")
    implementation("androidx.compose.runtime:runtime-livedata:1.3.0-rc01")
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha02")

    implementation("io.ktor:ktor-client-android:2.1.2")
    implementation("io.ktor:ktor-client-serialization:2.1.2")
    implementation("io.ktor:ktor-client-logging:2.1.2")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.2")

    implementation("io.coil-kt:coil-compose:2.2.2")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.cmota.unsplash"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}