package com.example.android.myapplication.contact

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.database.ContactDao
import com.example.android.myapplication.database.ContactDatabase

class ContactViewModelFactory(private val database: ContactDao, private val application: Application) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(database, application) as T
        }
       throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}