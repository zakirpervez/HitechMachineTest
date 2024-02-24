package com.hitech.hitechmachinetest.di

import com.hitech.hitechmachinetest.BuildConfig
import com.hitech.hitechmachinetest.api.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    /**
     * Provide the api request interceptor. This interceptor is used logging the request and response of the app.
     * @return [HttpLoggingInterceptor]
     */
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message ->
            Timber.d(message)
        }.apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    /**
     * Provide okhttp client instance. This client is used to add the interceptors to the request.
     * @param httpLoggingInterceptor: [HttpLoggingInterceptor].
     * @return [OkHttpClient]
     */
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    /**
     * Provide retrofit instance. This retrofit instance is used to make the api calls.
     * @param okHttpClient: [OkHttpClient].
     * return [Retrofit]
     */
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Provide the api service. This service is used to make the api calls.
     * @param retrofit: [Retrofit].
     * return [ApiService]
     */
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}
