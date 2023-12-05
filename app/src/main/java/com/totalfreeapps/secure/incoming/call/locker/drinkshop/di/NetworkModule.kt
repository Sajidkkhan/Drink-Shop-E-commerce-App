package com.totalfreeapps.secure.incoming.call.locker.drinkshop.di

import com.google.gson.GsonBuilder
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.api.DrinkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("https://www.ifocustec.com").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) : DrinkApi {
        return retrofit.create(DrinkApi::class.java)
    }
}