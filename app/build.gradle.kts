plugins{
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
    id(BuildPlugins.hilt)
    id(BuildPlugins.parcelize)
    id ("com.google.devtools.ksp") version "1.6.10-1.0.2"
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}


android {
    compileSdkVersion(AndroidSDK.compile)

    defaultConfig {
        applicationId = "com.example.geckocoin"
        minSdkVersion(AndroidSDK.min)
        targetSdkVersion(AndroidSDK.target)
        versionCode = Versions.code
        versionName = Versions.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (Libraries.ktxCore)
    implementation (Libraries.composeui)
    implementation (Libraries.material)
    implementation (Libraries.tooling_preview)
    implementation (Libraries.lifecycle_compose)
    implementation (Libraries.activity_compose)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${rootProject.extra["compose_version"]}")

    implementation (Libraries.navigation_compose)
    implementation (Libraries.flowlayout)
    implementation (Libraries.coroutines)
    implementation (Libraries.coroutines_core)
    implementation (Libraries.viewmodel)
    implementation (Libraries.runtime)
     //Dagger - Hilt
    implementation (Libraries.hilt)
    implementation (Libraries.nav_compose)
    implementation (Libraries.hilt_lifecycle)
    kapt (Libraries.compiler)
    kapt (Libraries.compiler_hilt)
      // Coil
    implementation (Libraries.coil)
    implementation (Libraries.timber)
    implementation (Libraries.raamcosta)
    ksp (Libraries.ksp)
    // Retrofit
    implementation (Libraries.retrofit2)
    implementation (Libraries.converter)
    implementation (Libraries.logging)
    implementation (Libraries.okhttp)

}


