package com.example.androidactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.androidactivity.model.ResponseAddMahasiswaItem

class InsertActivity : AppCompatActivity() {
    lateinit var txtNamaMhs : EditText
    lateinit var txtNim     : EditText
    lateinit var txtEmail   : EditText
    lateinit var txtAlamat  : EditText
    lateinit var txtNimProg : EditText
    lateinit var txtFoto    : EditText
    lateinit var btnSubmit  : Button
    lateinit var btnGetMhs  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        txtNamaMhs  = findViewById(R.id.txtNamaMhs)
        txtNim      = findViewById(R.id.txtNim)
        txtEmail    = findViewById(R.id.txtEmail)
        txtAlamat   = findViewById(R.id.txtAlamat)
        txtNimProg  = findViewById(R.id.txtNimProg)
        txtFoto     = findViewById(R.id.txtFoto)
        btnSubmit   = findViewById(R.id.btnSubmit)
        btnGetMhs   = findViewById(R.id.btnGetMhs)

        btnSubmit.setOnClickListener(View.OnClickListener { view ->
            val nim = txtNim.text.toString()
            val nama = txtNamaMhs.text.toString()
            val email = txtEmail.text.toString()
            val alamat = txtAlamat.text.toString()
            val foto    = txtFoto.text.toString()
            val nim_progmob = txtNimProg.text.toString()

            val postservice = PostApiService()
            val MhsData = ResponseAddMahasiswaItem(
                id = null,
                nim = nim, nama = nama, email = email, alamat = alamat, foto = foto, nim_progmob = nim_progmob
            )

            postservice.addMhs(MhsData) {
                if (ResponseAddMahasiswaItem().id != null) {
                    println("Success")
                } else {
                    println("error")
                }
            }
        })

        btnGetMhs.setOnClickListener (View.OnClickListener { view ->
            var bundle = Bundle()
            var intent = Intent(this@InsertActivity, GetMhsActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })
    }
}