plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.googleplugin)
    alias(libs.plugins.crashlyticsplugin)
}

android {
    namespace = "com.cds.callrecording"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.cds.callrecording"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }

    bundle {
        language {
            enableSplit = false
        }
    }
    lint {
        baseline = file("lint-baseline.xml")
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
    sourceSets {
        getByName("main") {
//            kotlin.srcDirs("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.play.services.measurement.api)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("com.google.android.ump:user-messaging-platform:4.0.0")
//    implementation("org.greenrobot:eventbus:3.3.1")
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")
//
//    // AndroidX Multidex
//    implementation ("androidx.multidex:multidex:2.0.1")
//
//    // EventBus (greenrobot)
//    implementation ("org.greenrobot:eventbus:3.3.1") // stable eventbus library :contentReference[oaicite:0]{index=0}
//
//    // SlideToAct (UI slide-to-unlock style)
//    implementation ("com.ncorti:slidetoact:2.1.0")
//
//    // Lottie (animations)
//    implementation ("com.airbnb.android:lottie:6.1.0")
//
//    // RoundedImageView
//    implementation ("com.makeramen:roundedimageview:2.3.0")
//
//    // Gson
//    implementation ("com.google.code.gson:gson:2.10.1")
//
//    // Retrofit + converters
//    implementation("com.squareup.retrofit2:retrofit:3.0.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
//
//    // OkHttp (core + logging)
//    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
//    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
//
//    // Room Database
//    implementation ("androidx.room:room-runtime:2.8.4")
//    implementation ("androidx.room:room-ktx:2.8.4")
////    kapt("androidx.room:room-compiler:2.8.4")
//
//    // Lifecycle
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.10.0")
//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")
//    implementation ("androidx.lifecycle:lifecycle-process:2.10.0")
//
//    // Glide (image loading)
//    implementation ("com.github.bumptech.glide:glide:4.15.1")
////    kapt ("com.github.bumptech.glide:compiler:4.15.1")
//
//    // Material Components
//    implementation ("com.google.android.material:material:1.13.0")
//
//    // Firebase — using BOM to manage versions
//    implementation (platform("com.google.firebase:firebase-bom:34.8.0")) // latest BoM :contentReference[oaicite:1]{index=1}
//    implementation ("com.google.firebase:firebase-analytics")
//    implementation ("com.google.firebase:firebase-crashlytics")
//    implementation ("com.google.firebase:firebase-config")
//    implementation ("com.google.firebase:firebase-messaging")
//
//    // Play Services Ads
//    implementation ("com.google.android.gms:play-services-ads:24.9.0") // latest from Firebase release notes :contentReference[oaicite:2]{index=2}

//    implementation(libs.androidx.multidex)
    implementation(libs.eventbus)
//    implementation(libs.slidetoact)
    implementation(libs.lottie)
    implementation(libs.roundedimageview)

    implementation(libs.google.gson)

    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.converter.gson)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.compiler)

    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.process)
    implementation(libs.androidx.lifecycle.runtime)

    implementation(libs.glide)
    ksp(libs.glide.compiler)

//    implementation(libs.play.services.ads)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.config)
    implementation(libs.firebase.messaging)
    implementation ("com.microsoft.clarity:clarity:2.3.0")
}