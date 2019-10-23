package com.biceps_studio.androidlayout.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.biceps_studio.androidlayout.R
import com.biceps_studio.androidlayout.utils.LocalStorage
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "Register"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val localStorage = LocalStorage(getActivity())

        val list: ArrayList<String> = ArrayList()
        list.add("Mahasiswa")
        list.add("Karyawan")
        list.add("Pengangguran")
        list.add("Lain-lain")

        //Membuat adapter untuk spinner, sehingga akan menampilkan dropdown dari vaiable list
        val adapter: ArrayAdapter<String> = ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, list)
        spList.adapter = adapter

        if (localStorage.getJob() != -1){
            spList.setSelection(localStorage.getJob())
        }

        //mengisi etname dari localstorage
        if (localStorage.getFullName() != null){
            etName.setText(localStorage.getFullName())
        }








        if(localStorage.getUserName() != null){
            etUsername.setText(localStorage.getUserName())
        }
        if(localStorage.getUserPassword() != null ){
            etPassword.setText(localStorage.getUserPassword())
        }
        if (localStorage.getRdGender() != 0){
//            spList.setSelection(localStorage.getJob())
        }

        //Membuat real time action pada edittext password
        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.e("afterTextChanged", p0!!.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("beforeTextChanged", p0!!.toString())
            }

            //Action real time untuk mendapatkan hasil input user
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Toast.makeText(getActivity(), p0!!.toString(), Toast.LENGTH_SHORT).show()
            }
        })

        //Membuat real time action pada checkbox
        cbTerm.setOnCheckedChangeListener { _, b ->
            if (b) { //Kondisi ketika checkbox dicheck
                Toast.makeText(getActivity(), "Anda menyutujui", Toast.LENGTH_SHORT).show()
            } else { //Kondisi ketika checkbox diuncheck
                Toast.makeText(getActivity(), "Anda tidak menyutujui", Toast.LENGTH_SHORT).show()
            }
        }

        //Membuat real time action pada radio group
        rgGender.setOnCheckedChangeListener { radioGroup, i ->
            //Mendapatkan object radion button yg ada didalam radio group
            val radioButton: RadioButton = radioGroup.findViewById(i)

            if (radioButton.isChecked) { //kondisi ketika radio button dipilih
                Toast.makeText(getActivity(), "Anda memilih ${radioButton.text}", Toast.LENGTH_SHORT).show()
            }
        }

        //Membuat real time action pada spinner
        spList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.e("TAG", "Not implemented")
            }

            //Action ketika user memilih option berdasarkan posisinya
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == (list.size - 1)){ //Kondisi ketika user memilih option terakhir pada spinner
                    etOther.visibility = View.VISIBLE
                } else { //Kondisi ketika user tidak memilih option terakhir pada spinner
                    etOther.visibility = View.GONE
                }
            }
        }

        //Memuat gambar dari url menggunakan Glide
        val url = "http://pngimg.com/uploads/android_logo/android_logo_PNG35.png"
        Glide.with(getActivity()).load(url).apply(RequestOptions.circleCropTransform()).into(ivAvatar)

        btnSubmit.setOnClickListener {


            if (etName.text.isNotEmpty()){
                localStorage.saveFullName(etName.text.toString())
            }
//                menyimpan isi dari etusername ke localstorage
            if (etUsername.text.isNotEmpty()){
                localStorage.saveUsername(etUsername.text.toString())
            }
            if(etPassword.text.isNotEmpty()){
                localStorage.savePassword(etPassword.text.toString())
            }

            localStorage.saveJob(spList.selectedItemPosition)

            startActivity(Intent(getActivity(), LoginActivity::class.java))
        }
    }

    private fun getActivity() : Context { return this }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}