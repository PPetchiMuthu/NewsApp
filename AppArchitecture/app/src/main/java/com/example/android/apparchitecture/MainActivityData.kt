package com.example.android.apparchitecture

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityData : ViewModel() {

    private val TAG: String =this.javaClass.simpleName
    private var myRandomNumber: String? = null

    fun getRandomNumber(): String? {
        Log.i(TAG,"Get function is called")
        if(myRandomNumber==null){
            createNumber()
        }
        return myRandomNumber
    }

    private fun createNumber() {
        Log.i(TAG,"Create Number is called")
        myRandomNumber = "The Number is" + (1..10).random()
    }

}