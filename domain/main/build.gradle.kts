plugins {
    alias(libs.plugins.androidbp.android.library)
    alias(libs.plugins.androidbp.hilt)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.razi.main"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    metricsDestination = layout.buildDirectory.dir("compose_compiler")
}
dependencies {
    implementation(libs.androidx.compose.runtime)
}