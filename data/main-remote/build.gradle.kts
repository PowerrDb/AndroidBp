plugins {
    alias(libs.plugins.androidbp.android.library)
    alias(libs.plugins.androidbp.hilt)
    alias(libs.plugins.jetbrainsKotlinSerialization)
}

android {
    namespace = "com.razi.main_remote"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "API_KEY", "\"a921fa0aef3e51da58481c65947d3687\"")

    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.converter)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.converter.gson)
}