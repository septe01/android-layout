package com.biceps_studio.androidlayout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            startActivity(Intent(getActivity(), ListActivity::class.java))
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(getActivity(), MainActivity::class.java))
        }
    }

    private fun getActivity() : Context { return this }
}
