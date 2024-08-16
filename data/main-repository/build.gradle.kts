plugins {
    alias(libs.plugins.androidbp.android.library)
    alias(libs.plugins.androidbp.hilt)
    alias(libs.plugins.androidbp.android.room)
}

android {
    namespace = "com.razi.main_repository"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

   implementation(project(":data:main-remote"))
   implementation(project(":data:main-local"))
   implementation(project(":domain:main"))

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}