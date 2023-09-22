package com.example.medicanew.model

import java.io.Serializable

data class Doctor(var img:Int, var name:String, var specialty:String, var status: Boolean = false):Serializable
