package com.example.androidactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.androidactivity.adapter.PetaniAdapter

class MainActivity : AppCompatActivity() {
    lateinit var tvMain : TextView
    lateinit var btnInputNama : Button
    lateinit var edInputNama : EditText
    lateinit var btnHelp : Button
    lateinit var btnRecycler : Button
    lateinit var btnCv : Button
    lateinit var btnGet : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMain = findViewById(R.id.tv_main_activity)
        tvMain.text = getString(R.string.text_progmob_main)

        btnInputNama = findViewById(R.id.btn_ambil_nama)
        btnHelp = findViewById(R.id.btn_help)
        edInputNama = findViewById(R.id.ed_input_nama)
        btnRecycler = findViewById(R.id.btnRecycler)
        btnCv = findViewById(R.id.btnCv)
        btnGet = findViewById(R.id.btnGet)

        btnInputNama.setOnClickListener(View.OnClickListener { view ->
            var strTmp = edInputNama.text.toString()
            tvMain.text = strTmp
        })

        btnRecycler.setOnClickListener(View.OnClickListener { view ->
            var bundle = Bundle()
            var intent = Intent(this@MainActivity, SampleRecyclerView::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })

        btnCv.setOnClickListener(View.OnClickListener { view ->
            var bundle = Bundle()
            var intent = Intent(this@MainActivity, SampleCardView::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })

        btnGet.setOnClickListener(View.OnClickListener { view ->
            var bundle = Bundle()
            var intent = Intent(this@MainActivity, ServiceActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        })

        btnHelp.setOnClickListener (View.OnClickListener {
            var bundle = Bundle()
            var strTmp = edInputNama.text.toString()
            bundle.putString("tesText",strTmp)
            var intent = Intent(this@MainActivity, HelpActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
            })



        }

    }