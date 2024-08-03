plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.hilt)
}

android {
    namespace = "com.razi.main"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}