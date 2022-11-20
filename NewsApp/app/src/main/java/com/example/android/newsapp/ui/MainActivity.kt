package com.example.android.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.android.newsapp.R
import com.example.android.newsapp.database.ArticleDatabase
import com.example.android.newsapp.repository.NewsRepository
import com.example.android.newsapp.ui.fragment.BreakingNewsFragment

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelFactory = NewsViewModelFactory(newsRepository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, BreakingNewsFragment()).commit()

    }
}
