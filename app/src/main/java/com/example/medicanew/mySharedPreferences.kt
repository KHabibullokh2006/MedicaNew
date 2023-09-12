package com.example.medicanew

import android.content.Context
import android.content.SharedPreferences

class mySharedPreferences(context: Context) {
    private val sharedPreferences:SharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)

    fun saveUser(email:String, password:String){
        sharedPreferences.edit().apply{
            putString("email", email)
            putString("password", password)
            putBoolean("status", true)
            apply()
        }
    }

    fun getUserEmail(): String? {
        return sharedPreferences.getString("email", null)
    }

    fun getUserPassword(): String? {
        return sharedPreferences.getString("password", null)
    }

    fun getUserStatus(): Boolean {
        return sharedPreferences.getBoolean("status", false)
    }

}