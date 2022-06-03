package com.example.newsapptask.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapptask.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrReplaceArticle(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete()
    suspend fun deleteArticle(article: Article)
}