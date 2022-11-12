package com.example.android.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.newsapp.repository.NewsRepository

class NewsViewModelFactory(val newsResposity: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsResposity) as T
    }
}