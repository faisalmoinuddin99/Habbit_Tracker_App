plugins {
    // Applying Android and Kotlin plugins
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    // Add this line for KAPT support
    id("org.jetbrains.kotlin.kapt") // For annotation processing (required for Room)
}

android {
    namespace = "com.example.habbittracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.habbittracker" // your app unique identifier
        minSdk = 24 // Minimum Android Version our app will support
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
// Configuring build types (Debug, Release)
    buildTypes {
        release {
            isMinifyEnabled = false // Minify to reduce app size in production
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Setting the Compiler Extension version for compose
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    //Configuring Kotlin options
    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Enabling Jetpack Compose for this project
    buildFeatures {
        compose = true
    }
    // Setting the Kotlin compiler extension version for Compose
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {

    // Core Android dependencies
    implementation(libs.androidx.core.ktx) // Kotlin extensions for Android core library
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle-aware components integration

    // Compose dependencies
    implementation(libs.androidx.activity.compose) // Allows activity to work with Jetpack Compose
    implementation(platform(libs.androidx.compose.bom)) // Compose BOM for version management
    implementation(libs.androidx.ui) // Core UI components for building Composables
    implementation(libs.androidx.ui.graphics) // Graphics components for Compose
    implementation(libs.androidx.ui.tooling.preview) // Enables UI previews in Android Studio
    implementation(libs.androidx.material3) // Material 3 components for styling UI

    // Unit testing dependencies
    testImplementation(libs.junit) // Standard JUnit testing framework

    // Android testing dependencies
    androidTestImplementation(libs.androidx.junit) // JUnit extension for Android
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose testing BOM
    androidTestImplementation(libs.androidx.ui.test.junit4) // JUnit4 support for Compose UI testing

    // Debug dependencies
    debugImplementation(libs.androidx.ui.tooling) // Debugging tools for UI inspection
    debugImplementation(libs.androidx.ui.test.manifest) // Manifest testing for UI in Compose

    // Additional Dependencies

    // Navigation Component for Compose - helps in navigating between different screens
    implementation("androidx.navigation:navigation-compose:2.7.4")

    // Room Database dependencies for local storage of habits
    implementation("androidx.room:room-runtime:2.6.1") // Room runtime library for database access
    kapt("androidx.room:room-compiler:2.6.1") // Room annotation processor for generating necessary code
    implementation("androidx.room:room-ktx:2.6.1") // Kotlin extensions for Room for better syntax

    // Lifecycle and ViewModel integration with Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // Integrates ViewModel with Jetpack Compose

    // Coroutines for managing background tasks and asynchronous programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Coroutines library for Android
}
