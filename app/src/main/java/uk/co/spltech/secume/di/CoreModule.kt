package uk.co.spltech.secume.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.spltech.secume.api.ApiService
import uk.co.spltech.secume.util.SchedulerProvider
import java.util.concurrent.TimeUnit

val coreModule = module {

    single("IO_SCHEDULER") { Schedulers.io() }
    single("MAIN_THREAD_SCHEDULER") { AndroidSchedulers.mainThread() }

    single {
        SchedulerProvider(
            backgroundScheduler = get("IO_SCHEDULER"),
            foregroundScheduler = get("MAIN_THREAD_SCHEDULER")
        )
    }
}

val networkModule = module {
    single {
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()
    }

    single { createOkHttpClient() }

    single {
        createRetrofitService<ApiService>(
            okHttpClient = get(),
            url = "https://newsapi.org/v2/",
            gson = get()
        )
    }
}

private fun createOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(interceptor).build()
}

private inline fun <reified T> createRetrofitService(okHttpClient: OkHttpClient, url: String, gson: Gson): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}

