// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:11.6.1")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.1")
        // Note: Added unmock to avoid the potential issue with JNI code initialization like Uri.EMPTY
        classpath("com.github.bjoernq:unmockplugin:0.7.9")
    }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")
apply(plugin = "io.gitlab.arturbosch.detekt")