plugins {
    alias(libs.plugins.androidbp.feature)
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.razi.popular_movie"

}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    metricsDestination = layout.buildDirectory.dir("compose_compiler")
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