package com.biceps_studio.androidlayout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ArrayList<String> = ArrayList()
        list.add("Mahasiswa")
        list.add("Karyawan")
        list.add("Pengangguran")
        list.add("Lain-lain")

        //Membuat adapter untuk spinner, sehingga akan menampilkan dropdown dari vaiable list
        val adapter: ArrayAdapter<String> = ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, list)
        spList.adapter = adapter

        //Memuat gambar dari url menggunakan Glide
        val url = "http://pngimg.com/uploads/android_logo/android_logo_PNG35.png"
        Glide.with(getActivity()).load(url).apply(RequestOptions.circleCropTransform()).into(ivAvatar)

        btnSubmit.setOnClickListener {
            startActivity(Intent(getActivity(), LoginActivity::class.java))
        }
    }

    private fun getActivity() : Context { return this }
}