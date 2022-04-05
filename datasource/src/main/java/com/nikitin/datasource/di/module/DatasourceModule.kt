package com.nikitin.datasource.di.module

import com.google.gson.GsonBuilder
import com.nikitin.datasource.BuildConfig
import com.nikitin.datasource.network.API
import com.nikitin.datasource.search.remote.source.RemoteDataSource
import com.nikitin.datasource.search.remote.source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DatasourceModule {
    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonBuilder()
            .setLenient()
            .create().let {
                GsonConverterFactory.create(it)
            }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            addInterceptor(logging)
            connectTimeout(BuildConfig.GITHUB_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(BuildConfig.GITHUB_READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(BuildConfig.GITHUB_WRITE_TIMEOUT, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    @Singleton
    fun provideApi(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): API {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GITHUB_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
            .create(API::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource {
        return remoteDataSource
    }
}