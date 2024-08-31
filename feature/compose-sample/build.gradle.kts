plugins {
    alias(libs.plugins.androidbp.feature)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.razi.compose_sample"
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    metricsDestination = layout.buildDirectory.dir("compose_compiler")
}

dependencies {
    //compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
}