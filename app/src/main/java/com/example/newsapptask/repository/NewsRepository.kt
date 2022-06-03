package com.example.newsapptask.repository

import androidx.room.Database
import com.example.newsapptask.data.local.AppDataBase
import com.example.newsapptask.data.local.ArticleDao
import com.example.newsapptask.data.remote.api.RetrofitInstance
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val db: AppDataBase,
    private val articleDao: ArticleDao,
) {

    suspend fun getTopNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopNews(countryCode, pageNumber)
}