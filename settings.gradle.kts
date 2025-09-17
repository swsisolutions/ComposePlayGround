pluginManagement {
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

rootProject.name = "ComposePlayground"
include(":app")
include(":core")
include(":core:domain")
include(":core:ui")
include(":core:network")
include(":features")
include(":features:account")
include(":features:moviedb")
include(":features:play")
include(":features:sideeffect")
include(":core:common")
include(":swsiuikit")
