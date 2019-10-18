package com.biceps_studio.androidlayout

import android.content.Context
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

        val adapter: ArrayAdapter<String> = ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, list)
        spList.adapter = adapter

        Glide.with(getActivity()).load("http://pngimg.com/uploads/android_logo/android_logo_PNG35.png").apply(RequestOptions.circleCropTransform()).into(ivAvatar)
    }

    private fun getActivity() : Context { return this }
}