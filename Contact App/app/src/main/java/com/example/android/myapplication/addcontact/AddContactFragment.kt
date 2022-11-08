package com.example.android.myapplication.addcontact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.myapplication.R
import com.example.android.myapplication.database.ContactDatabase
import com.example.android.myapplication.databinding.FragmentContactBinding

class AddContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = ContactDatabase.getInstance(application)!!.contactDao
        val addContactViewModelFactory = AddContactViewModelFactory(dao, application)
        val viewModel =
            ViewModelProvider(this, addContactViewModelFactory)[AddContactViewModel::class.java]

        binding.contactViewModel = viewModel
        binding.lifecycleOwner = this

        return view
    }


}