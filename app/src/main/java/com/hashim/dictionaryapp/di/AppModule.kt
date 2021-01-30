/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hashim.dictionaryapp.repository.remote.RemoteRepo
import com.hashim.dictionaryapp.repository.remote.RemoteRepoImpl
import com.hashim.dictionaryapp.repository.remote.RetrofitService
import com.hashim.dictionaryapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun hProvidesGson(): Gson? {
        return GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .create()
    }


    @Singleton
    @Provides
    fun hProvidesRetrofitService(gson: Gson?): RetrofitService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)


        return Retrofit.Builder()
            .baseUrl(Constants.H_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(logging)
                    .build()
            )
            .build()
            .create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun hProvidesApi(): String {
        return Constants.H_API_KEY
    }

    @Singleton
    @Provides
    fun hProvidesRemoteRepo(retrofitService: RetrofitService, key: String): RemoteRepo {
        return RemoteRepoImpl(retrofitService, key)
    }


}