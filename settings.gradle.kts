pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Androidbp"
include(":app")
include(":data:main-repository")
include(":data:main-local")
include(":data:main-remote")
include(":domain")
include(":core")
include(":feature")
include(":feature:main")
include(":domain:mainn")
include(":domain:main")

include(":core:navigation")
