pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "paper-kotlin-template"
include("plugin")
include("api")
