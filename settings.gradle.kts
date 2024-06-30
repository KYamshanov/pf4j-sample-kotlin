rootProject.name = "pf4j-sample-kotlin"

// for use libs.any_lib in dependency declaration
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}


include("api")
include("core")
include("hello-plugin")
