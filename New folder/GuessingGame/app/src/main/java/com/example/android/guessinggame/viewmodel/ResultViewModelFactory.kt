package com.example.android.guessinggame.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResultViewModelFactory(private val finalResult :String):ViewModelProvider.Factory {

    @SuppressLint("SuspiciousIndentation")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java))
        return ResultViewModel(finalResult) as T
        throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }
}