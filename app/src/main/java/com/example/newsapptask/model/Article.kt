package com.example.newsapptask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapptask.model.Source

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
)