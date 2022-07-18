buildscript {
    val compose_version by extra("1.0.1")

    dependencies {
//        classpath(BuildPlugins.androidGradlePlugin)
//        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(Libraries.hilt_classpath)
    }
  }// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id ("com.android.application") version "7.1.3" apply false
    id ("com.android.library") version "7.1.3" apply false
    id ("org.jetbrains.kotlin.android") version "1.5.21" apply false
}
tasks.register("clean").configure{
    delete("build")
}