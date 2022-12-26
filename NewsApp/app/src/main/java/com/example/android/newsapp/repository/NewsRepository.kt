package com.example.android.newsapp.repository

import com.example.android.newsapp.api.RetrofitInstance
import com.example.android.newsapp.db.ArticleDatabase
import com.example.android.newsapp.models.Article

class NewsRepository(private val database: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = database.getArticleDao().insert(article)

    fun getSavedNews() = database.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = database.getArticleDao().deleteArticle(article)
}