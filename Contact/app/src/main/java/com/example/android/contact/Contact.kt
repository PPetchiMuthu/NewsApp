package com.example.android.contact

data class Contact(val firstName:String,val lastName:String,val phoneNo:String)

class ContactList{
   val contact : List<Contact> = listOf(
       Contact("Ram","Kumar","9789787688"),
       Contact("Arul"," Kumar", "8799787613"),
       Contact("Daniel"," Raj", "9896457632",)
   )
}