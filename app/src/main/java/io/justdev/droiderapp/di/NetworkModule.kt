package io.justdev.droiderapp.di

import dagger.Module
import dagger.Provides
import io.justdev.droiderapp.BuildConfig
import io.justdev.droiderapp.Consts.HOME_URL
import io.justdev.droiderapp.api.DroiderApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideDroiderApi(): DroiderApi {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HOME_URL)
                .client(httpClient())
                .build()
                .create(DroiderApi::class.java)
    }

    private fun httpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            client.addInterceptor(loggingInterceptor)
        }
        client.connectTimeout(15, TimeUnit.SECONDS)
        client.readTimeout(30, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)
        return client.build()
    }
}
