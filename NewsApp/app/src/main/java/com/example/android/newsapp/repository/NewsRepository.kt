package com.example.android.newsapp.repository


import com.example.android.newsapp.api.RetrofitInstance
import com.example.android.newsapp.database.ArticleDatabase

class NewsRepository(articleDatabase: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}