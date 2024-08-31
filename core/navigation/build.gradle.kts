plugins {
    alias(libs.plugins.androidbp.android.library)
    alias(libs.plugins.androidbp.android.library.compose)
}

android {
    namespace = "com.razi.navigation"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

}

dependencies {

    api(libs.androidx.navigation.compose)
}