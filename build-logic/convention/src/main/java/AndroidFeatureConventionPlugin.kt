import com.razi.convention.androidGradle
import com.razi.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyDependencies()
            androidGradle {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply("razi.androidbp.library")
            apply("razi.androidbp.library.compose")
            apply("razi.androidbp.hilt")
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            "implementation"(libs.findLibrary("androidx-hilt-navigation-compose").get())
            "androidTestImplementation"(libs.findLibrary("runner").get())
            "api"(project(":core:designsystem"))

        }
    }
}