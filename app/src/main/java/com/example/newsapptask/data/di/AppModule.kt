package com.example.newsapptask.data.di

import android.content.Context
import androidx.room.Room
import com.example.newsapptask.data.local.AppDataBase
import com.example.newsapptask.data.repository.NewsRepositoryImpl
import com.example.newsapptask.model.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
abstract class AppModule {

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

    @Binds
    abstract fun bindNewsRepositoryImpl(repository: NewsRepositoryImpl): NewsRepository
}