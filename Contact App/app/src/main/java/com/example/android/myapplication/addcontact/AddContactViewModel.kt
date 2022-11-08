package com.example.android.myapplication.addcontact

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.myapplication.database.ContactDao
import com.example.android.myapplication.database.Contact
import kotlinx.coroutines.launch

class AddContactViewModel(val dao: ContactDao, application: Application):ViewModel() {

    private var contact = MutableLiveData<Contact>()

    var newFirstName = MutableLiveData("")
    var newLastName = MutableLiveData("")
    var newPhoneNo = MutableLiveData("")
    var newEmail = MutableLiveData("")

    suspend fun addCondact(){
//        dao.insert(contact)
        var _firstName = newFirstName.value
        var _lastName = newLastName.value
        var _phoneNo = newPhoneNo.value
        var _newEmail = newEmail.value
        viewModelScope.launch {
            val contact = Contact()
            contact.firstName = _firstName.toString()
            contact.lastName = _lastName.toString()
            contact.phoneNo = _phoneNo.toString()
            contact.email = _newEmail.toString()
            dao.insert(contact)
        }
        newFirstName.value=""
        newLastName.value=""
        newPhoneNo.value=""
        newEmail.value=""
    }
}
