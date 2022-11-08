package com.example.android.apparchitecture

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var myData :MainActivityData

    private val TAG: String =this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textData:TextView = findViewById(R.id.textView)
        myData = ViewModelProvider(this).get(MainActivityData::class.java)
        val myRandom = myData.getRandomNumber()
        textData.text = myRandom

        Log.i(TAG,"Random Number set")
    }
}