package com.totalfreeapps.secure.incoming.call.locker.drinkshop.di

import android.content.Context
import androidx.room.Room
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "dictionary").build()

    @Singleton
    @Provides
    fun provideSKUDao(appDatabase: AppDatabase) = appDatabase.skuDao()

}