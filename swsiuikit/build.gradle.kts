plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.swasi.uikit"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.swasi.uikit"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // 1. Compose Bill of Materials (BOM)
    // The BOM simplifies dependency management by allowing you to omit versions for Compose libraries.
    val composeBom = platform("androidx.compose:compose-bom:2024.05.00")
    implementation(composeBom)
    androidTestImplementation(composeBom) // Also for testing

    // 2. Core UI Components
    implementation("androidx.compose.ui:ui") // Core UI elements (Modifier, Layout, etc.)
    implementation("androidx.compose.ui:ui-graphics") // Graphics primitives

    // 3. Material Design 3
    // For Material Design components like Button, Card, Scaffold. Use this for new apps.
    implementation("androidx.compose.material3:material3")

    // Note: For older projects using Material 2, you would use this instead:
    // implementation("androidx.compose.material:material")

    // 4. Android Integration
    // Required to use setContent {} in an Activity.
    implementation("androidx.activity:activity-compose:1.9.0")

    // 5. Tooling and Previews
    // Needed for @Preview composables to work in Android Studio.
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling") // For tools like Layout Inspector

    // A. Navigation
    // For navigating between screens/composables in a declarative way.
    implementation("androidx.navigation:navigation-compose:2.9.3")

    // B. ViewModel Integration
    // For using `viewModel()` composable to get a ViewModel instance.
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")

    // C. Lifecycle-aware State Collection (e.g., from a Flow)
    // Provides `collectAsStateWithLifecycle()` to safely collect flows from the UI.
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.2")

    // D. ConstraintLayout
    // For creating complex layouts with constraints, similar to the classic View system.
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.1")

    // E. Paging
    // For displaying large, paged lists of data from sources like network or database.
    implementation("androidx.paging:paging-compose:3.3.6")

    // F. Hilt Integration (for Dependency Injection)
    // Simplifies injecting dependencies into your ViewModels and Composables.
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // G. Coil (for Image Loading) - Recommended 3rd party library
    // A modern, Kotlin-first image loading library.
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Import the BOM for the test scope
    androidTestImplementation(composeBom)

    // Core library for UI testing in Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Needed for creating a ComposeTestRule and running tests
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // bottombar
    implementation(platform("androidx.compose:compose-bom:2025.08.00"))
    implementation ("androidx.compose.material:material-icons-extended")
}