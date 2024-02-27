// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.jlleitschuh.gradle.ktlint)
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        google()
    }
    dependencies {
        classpath(libs.ktlint.gradle)
        classpath(libs.detekt.gradle.plugin)
        // Note: Added unmock to avoid the potential issue with JNI code initialization like Uri.EMPTY
        classpath(libs.unmockplugin)
    }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")
apply(plugin = "io.gitlab.arturbosch.detekt")

