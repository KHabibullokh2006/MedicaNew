package com.example.medicanew

import android.content.Context
import android.content.SharedPreferences
import com.example.medicanew.model.Doctor

class mySharedPreferences(context: Context) {
    private val sharedPreferences:SharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
    private val doctors:MutableList<Doctor> = mutableListOf()
    private val favDoctors:MutableList<Doctor> = mutableListOf()

    companion object{
        private var instance: mySharedPreferences? = null
        fun newInstance(context: Context): mySharedPreferences {
            if (instance == null) {
                instance = mySharedPreferences(context)
            }
            instance!!.addDoctors()
            return instance!!
        }
    }
    fun saveUser(username:String, email:String, password:String){
        sharedPreferences.edit().apply{
            putString("email", email)
            putString("username",username)
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

    fun getUserUsername(): String? {
        return sharedPreferences.getString("username", null)
    }

    fun getUserStatus(): Boolean {
        return sharedPreferences.getBoolean("status", false)
    }

    fun addDoctors():MutableList<Doctor>{
        doctors.add(Doctor(R.drawable.img, "Dr. Travis Westaby", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_1, "Dr. Nathaniel Valle", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_2, "Dr. Beckett Calger", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_3, "Dr. Joda Srnsky", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_4, "Dr. Bernard Bliss", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_5, "Dr. Randy Wigham", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_6, "Dr. Jenny Watson", "Immunologist"))
        doctors.add(Doctor(R.drawable.img_7, "Dr. Raul Zirkind", "Neurologist"))
        doctors.add(Doctor(R.drawable.img_8, "Dr. Elijah Baranick", "Allergist"))

        return doctors

    }
    
    fun favoriteDoctors():MutableList<Doctor>{
        for (doctor in doctors) {
            if (doctor.status){
                favDoctors.add(Doctor(doctor.img,doctor.name, doctor.specialty, doctor.status))
            }
        }
        return favDoctors
    }





}