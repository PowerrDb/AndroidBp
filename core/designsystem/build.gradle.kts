plugins {
    alias(libs.plugins.androidbp.android.library)
    alias(libs.plugins.androidbp.android.library.compose)
}

android {
    namespace = "com.razi.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)

}