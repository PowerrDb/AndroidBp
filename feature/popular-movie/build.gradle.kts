plugins {
    alias(libs.plugins.androidbp.feature)
}

android {
    namespace = "com.razi.popular_movie"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {
    implementation(project(":domain:main"))
    //compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    //collection
    implementation(libs.kotlinx.collections.immutable)
    //Gson
    implementation(libs.converter.gson)
    // Coil
    implementation(libs.coil.compose)
}