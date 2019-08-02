object Versions {
    val kotlin = "1.3.41"
    val coroutinesCore = "1.2.1"
    val coroutinesAndroid = "1.1.1"
    val navigationVersion = "2.0.0"
    val lifecycleVersion = "2.0.0"
    val lifecycleKtxVersion = "2.2.0-alpha01"
    val pagingKtxVersion = "2.1.0"
    val retrofitVersion = "2.4.0"
    val roomVersion = "2.1.0-rc01"
    val glideVersion = "4.9.0"
    val okhttp3Version = "3.9.0"
    val koinVersion = "2.0.0"
    val retrofit2KotlinCoroutinesAdapter = "0.9.2"
}

object Config {
    //Kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    //Coroutines
    val kotlin_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    val kotlin_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    //Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    // Android Arch
    val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtxVersion}"
    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtxVersion}"
    val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtxVersion}"
    // Koin
    val koin = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"
    // Retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val converter_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    val retrofit2_kotlin_coroutines_adapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit2KotlinCoroutinesAdapter}"
    // Navigation
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    // Room
    val room_runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
    val room_compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    val room_ktx = "androidx.room:room-ktx:${Versions.roomVersion}"
    //Paging Component
    val paging = "androidx.paging:paging-runtime-ktx:${Versions.pagingKtxVersion}"
    // Okhttp
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
    val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Version}"
}

