const val kotlinVersion = "1.3.70"

object BuildConfig {
    object Versions {
        const val buildToolsVersion = "3.6.3"
    }

    const val androidToolBuild = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
}

object AndroidConfig {
    const val compileSdkVersion = 29
    const val buildToolsVersion = "29.0.3"

    const val applicationId = "bot.box.covidtracker"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"

    const val enableMultiDex = true
    const val enableDataBinding = true
}

object Dependencies {
    private object Versions {
        const val appCompat = "1.1.0"
        const val coreKtx = "1.2.0"
        const val constraint = "1.1.3"
        const val material = "1.2.0-alpha03"
        const val dagger = "2.20"
        const val rxJava = "2.1.1"
        const val rxJavaAndroid = "2.1.1"
        const val picasso = "2.71828"
        const val lifeCycleArch = "2.1.0"
        const val retrofit = "2.7.0"
        const val okhttp = "4.2.2"
        const val koin = "2.0.1"
        const val multidex = "2.0.1"
        const val navigation = "2.2.1"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVersion}"
    const val appCompatLib = "androidx.appcompat:appcompat:${Dependencies.Versions.appCompat}"
    const val coreKtxLib = "androidx.core:core-ktx:${Dependencies.Versions.coreKtx}"
    const val constraintLib =
        "androidx.constraintlayout:constraintlayout:${Dependencies.Versions.constraint}"

    const val materialLib = "com.google.android.material:material:${Dependencies.Versions.material}"

    //dagger2
    const val daggerLib = "com.google.dagger:dagger:${Dependencies.Versions.dagger}"
    const val daggerAndroidLib = "com.google.dagger:dagger-android:${Dependencies.Versions.dagger}"
    const val daggerAndroidSupportLib =
        "com.google.dagger:dagger-android-support:${Dependencies.Versions.dagger}"
    const val daggerCompilerLib =
        "com.google.dagger:dagger-compiler:${Dependencies.Versions.dagger}"
    const val daggerAnnotationProcessorLib =
        "com.google.dagger:dagger-android-processor:${Dependencies.Versions.dagger}"

    //rx-java
    const val rxJavaLib = "io.reactivex.rxjava2:rxjava:${Dependencies.Versions.rxJava}"
    const val rxJavaAndroidLib =
        "io.reactivex.rxjava2:rxandroid:${Dependencies.Versions.rxJavaAndroid}"

    //picasso
    const val picassoLib = "com.squareup.picasso:picasso:${Dependencies.Versions.picasso}"

    //arch components
    const val lifeCycleLib =
        "androidx.lifecycle:lifecycle-extensions:${Dependencies.Versions.lifeCycleArch}"
    const val lifeCycleViewModelLib =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Dependencies.Versions.lifeCycleArch}"


    //retrofit
    const val retrofitLib = "com.squareup.retrofit2:retrofit:${Dependencies.Versions.retrofit}"
    const val retrofitGsonConverterLib =
        "com.squareup.retrofit2:converter-gson:${Dependencies.Versions.retrofit}"
    const val retrofitRxAdapter =
        "com.squareup.retrofit2:adapter-rxjava2:${Dependencies.Versions.retrofit}"
    const val okHttpLib = "com.squareup.okhttp3:logging-interceptor:${Dependencies.Versions.okhttp}"

    //swipe refresh layout
    const val swipeRefreshLayoutLib = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

    //koin
    const val koinLib = "org.koin:koin-androidx-viewmodel:${Dependencies.Versions.koin}"
    const val koinAndroidLib = "org.koin:koin-android:${Dependencies.Versions.koin}"

    //multidex
    const val multiDexLib = "androidx.multidex:multidex:${Dependencies.Versions.multidex}"

    //navigation controller
    const val navigationLib = "androidx.navigation:navigation-fragment-ktx:${Dependencies.Versions.navigation}"
    const val navigationUILib = "androidx.navigation:navigation-ui-ktx:${Dependencies.Versions.navigation}"
}

object TestDependencies {
    private object Versions {
        const val jUnit = "4.12"
        const val jUnitExt = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val jUnitTestLib = "junit:junit:${TestDependencies.Versions.jUnit}"
    const val jUnitExtLib = "androidx.test.ext:junit:${TestDependencies.Versions.jUnitExt}"
    const val espressoLib =
        "androidx.test.espresso:espresso-core:${TestDependencies.Versions.espresso}"
}
