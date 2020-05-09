plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    buildToolsVersion(AndroidConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        multiDexEnabled = AndroidConfig.enableMultiDex

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    dataBinding {
        isEnabled = AndroidConfig.enableDataBinding
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
       targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlinStdLib)
    testImplementation(TestDependencies.jUnitTestLib)
    androidTestImplementation(TestDependencies.jUnitExtLib)
    androidTestImplementation(TestDependencies.espressoLib)

    implementation(Dependencies.appCompatLib)

    implementation(Dependencies.coreKtxLib)

    implementation(Dependencies.constraintLib)

    implementation(Dependencies.materialLib)


    implementation(Dependencies.picassoLib)

    implementation(Dependencies.lifeCycleLib)
    implementation(Dependencies.lifeCycleViewModelLib)

    implementation(Dependencies.swipeRefreshLayoutLib)

    implementation(Dependencies.koinLib)
    implementation(Dependencies.koinAndroidLib)

    implementation(Dependencies.multiDexLib)

    implementation(Dependencies.navigationLib)
    implementation(Dependencies.navigationUILib)

    implementation(Dependencies.sdp)
    implementation(Dependencies.ssp)

    api(project(":data"))
}
