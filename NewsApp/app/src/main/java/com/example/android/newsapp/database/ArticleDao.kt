package com.example.android.newsapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.newsapp.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upset(article: Article): Long

    @Query("SELECT * FROM article")
    fun getAllArticle(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}