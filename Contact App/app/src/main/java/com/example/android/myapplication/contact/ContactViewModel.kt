package com.example.android.myapplication.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.android.myapplication.database.Contact
import com.example.android.myapplication.database.ContactDao

class ContactViewModel(private val dao: ContactDao, application: Application) :
    AndroidViewModel(application) {
    var contact: MutableLiveData<List<Contact>>

    init {
        contact = MutableLiveData()
    }

    fun getAllContact() {
        val list = dao.getAll()
        contact.postValue(list)
    }
}

