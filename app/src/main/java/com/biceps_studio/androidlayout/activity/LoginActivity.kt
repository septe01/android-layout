package com.biceps_studio.androidlayout.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.biceps_studio.androidlayout.R
import com.biceps_studio.androidlayout.utils.LocalStorage
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val localStorage = LocalStorage(getActivity())

        btnLogin.setOnClickListener {
            startActivity(Intent(getActivity(), ListActivity::class.java))
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(getActivity(), MainActivity::class.java))
        }
        
        if (localStorage.getFullName().isNotEmpty()) {
            Toast.makeText(getActivity(), "Full name : ${localStorage.getFullName()}", Toast.LENGTH_LONG).show()

            startActivity(Intent(getActivity(), ListActivity::class.java))
            finish()
        }
    }

    private fun getActivity() : Context { return this }
}
