package com.biceps_studio.androidlayout.utils

import android.content.Context
import android.content.SharedPreferences

class LocalStorage(private val context: Context) {

    private val key = "com.biceps_studio.androidlayout.utils"
    private val private = 0

    private val fullName = "fullName"
    private val userName = "userName"
    private val userPassword = "userPasword"
    private val userGender = "userGender"
    private val job = "job"
    fun saveFullName(string: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(fullName, string)
        editor.apply()
    }
    fun getFullName() : String {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        return sharedPreferences.getString(fullName, "")!!
    }
    fun saveUsername(string: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(userName, string)
        editor.apply()
    }
    fun getUserName() : String{
        val sharedPreferences : SharedPreferences = context.getSharedPreferences(key, private)
        return sharedPreferences.getString(userName, "")!!
    }
    fun savePassword(string: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(userPassword, string)
        editor.apply()
    }
    fun getUserPassword(): String{
        val sharedPreferences : SharedPreferences = context.getSharedPreferences(key, private)
        return sharedPreferences.getString(userPassword, "")!!
    }
    fun saveRgGender(int: Int){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(userGender, int)
        editor.apply()
    }
    fun getRdGender(): Int{
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        return sharedPreferences.getInt(userGender, 0)
    }

    fun saveJob(int: Int){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(job, int)
        editor.apply()
    }

    fun getJob() : Int {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)

        return sharedPreferences.getInt(job, -1)
    }
}