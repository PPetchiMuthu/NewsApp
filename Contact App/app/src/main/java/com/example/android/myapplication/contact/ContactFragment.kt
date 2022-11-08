package com.example.android.myapplication.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.R
import com.example.android.myapplication.database.ContactDatabase
import com.example.android.myapplication.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentContactBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = ContactDatabase.getInstance(application)!!.contactDao
        val viewModelFactory = ContactViewModelFactory(dataSource,application)
        val contactViewModel= ViewModelProvider(this,viewModelFactory).get(ContactViewModel::class.java)
        binding.setLifecycleOwner(this)

        binding.contactViewModel = contactViewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }

}