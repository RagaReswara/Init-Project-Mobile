package com.example.androidactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SampleList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnShowList : Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)

        btnShowList = findViewById(R.id.btnShowList)
        btnShowList.setOnClickListener (View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleListView::class.java)
            startActivity(intent)
        })
    }

}