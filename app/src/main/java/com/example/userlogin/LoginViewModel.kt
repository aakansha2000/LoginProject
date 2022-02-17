package com.example.userlogin

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    lateinit var username:String
    lateinit var password:String
     var valid:Boolean=false
    init {
        Log.i("LoginViewModel","viewmodel init block ")
    }

     fun checkUserEmail(): Boolean {
        val emailToText: String = username.toString()
         valid = !emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()
         return valid
    }

}