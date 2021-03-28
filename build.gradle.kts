import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
    application
}

group = "com.ademir"
version = "1.0-SNAPSHOT"

sourceSets["main"].java.srcDir(listOf("src/main", "build/generated/ksp/main/kotlin"))

application {
    mainClassName = "MainKt"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project("annotations"))
    ksp(project("annotations"))
}
