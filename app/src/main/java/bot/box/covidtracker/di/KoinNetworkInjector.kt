package bot.box.covidtracker.di

import bot.box.covidtracker.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val provideRetrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideOkHttpClient)
        .build()
}

private val provideOkHttpClient by lazy {
    OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(3, TimeUnit.MINUTES)
        .addInterceptor(provideHTTPLoginInterceptor)
        .build()
}

private val provideHTTPLoginInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
