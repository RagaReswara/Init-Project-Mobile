package com.example.androidactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EditData : AppCompatActivity() {
    lateinit var editData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data)
        editData = findViewById(R.id.editNama)
            val username = intent.getStringExtra("username")
        editData.text = username
    }
}