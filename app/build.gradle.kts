plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

kapt {
    correctErrorTypes = true
}

android {
    namespace = "com.example.pokedex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokedex"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val navVersion = "2.7.4"
    val retrofitVersion = "2.9.0"
    val koinVersion = "3.5.0"
    val epoxyVersion = "5.1.3"
    val shimmerVersion = "0.5.0"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Navigation
    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:$navVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-jackson:$retrofitVersion")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    //Koin
    implementation("io.insert-koin:koin-android:$koinVersion")

    //Epoxy
    implementation("com.airbnb.android:epoxy:$epoxyVersion")
    kapt("com.airbnb.android:epoxy-processor:$epoxyVersion")

    //Shimmer
    implementation("com.facebook.shimmer:shimmer:$shimmerVersion")

    //coil
    implementation("io.coil-kt:coil:2.4.0")
    implementation("io.coil-kt:coil-svg:2.4.0")
}