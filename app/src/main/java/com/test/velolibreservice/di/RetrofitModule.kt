package com.test.velolibreservice.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.test.velolibreservice.VeloLibreServiceApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.test.velolibreservice.data.StationApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()))
        .build()

    @Singleton
    @Provides
    fun provideStationApi(retrofit: Retrofit): StationApi =
        retrofit.create(StationApi::class.java)

    companion object {
        const val BASE_URL = "https://api.jcdecaux.com/vls/v1/"
    }
}