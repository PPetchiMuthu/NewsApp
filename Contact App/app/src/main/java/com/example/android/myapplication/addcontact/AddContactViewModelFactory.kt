package com.example.android.myapplication.addcontact

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.database.ContactDao

class AddContactViewModelFactory(private val database: ContactDao, private val application: Application) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddContactViewModel::class.java)) {
            return AddContactViewModel(database, application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}