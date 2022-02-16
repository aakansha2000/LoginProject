package com.example.userlogin

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    lateinit var username:String
    lateinit var password:String
    init {
        Log.i("LoginViewModel","viewmodel init block ")
    }
}