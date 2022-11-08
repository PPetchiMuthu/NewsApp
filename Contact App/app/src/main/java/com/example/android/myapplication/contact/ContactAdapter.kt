package com.example.android.myapplication.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.myapplication.R
import com.example.android.myapplication.database.Contact as Contact

class ContactAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var list: List<Contact>

    fun addListData(data: List<Contact>) {
        this.list = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_contact,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.myTextView.text = list[position].toString()
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val myTextView: TextView = view.findViewById(R.id.txtTitle)


    }
}


