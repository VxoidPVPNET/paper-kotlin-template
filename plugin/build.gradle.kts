import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.10"
    id("io.papermc.paperweight.userdev") version "1.7.3"
}

group = "net.vxoidpvp"
version = "1.0.0"

val kSpigotVersion = "1.21.0"
val mcVersion = "1.21.1"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.lucko.me/")
}

dependencies {
    implementation(project(":api"))
    paperDevBundle("${mcVersion}-R0.1-SNAPSHOT")
    implementation("net.axay:kspigot:${kSpigotVersion}")
    implementation("com.github.VxoidPVP:localization:1.0.0")
}

tasks {
    build {
        dependsOn(reobfJar)
    }

    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.add("-Xjvm-default=all")
        }
    }
}
