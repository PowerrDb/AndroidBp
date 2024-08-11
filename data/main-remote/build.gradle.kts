plugins {
    alias(libs.plugins.androidbp.android.library)
    alias(libs.plugins.androidbp.hilt)
}

android {
    namespace = "com.razi.main_remote"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.converter)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
}