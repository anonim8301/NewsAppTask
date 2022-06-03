package com.example.newsapptask.data.di

import android.content.Context
import androidx.room.Room
import com.example.newsapptask.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNewsAppDataBase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "app_db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: AppDataBase) = db.getDao()
}