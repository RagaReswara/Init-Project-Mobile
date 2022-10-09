package com.example.androidactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidactivity.adapter.PetaniAdapter
import com.example.androidactivity.adapter.PetaniAdapterCv
import com.example.androidactivity.model.Petani

lateinit var petani2: List<Petani>
lateinit var recyclerView2: RecyclerView
lateinit var petaniAdapter2: PetaniAdapterCv

class SampleCardView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_card_view)

        recyclerView2 = findViewById(R.id.rvCardView)
        petani2 = listOf(
            Petani(user = "dudes1","Jojo","500","30","200"),
            Petani(user = "dudes2","Ribak","200","10","100"),
            Petani(user = "dudes3","Kris","300","20","200"),
            Petani(user = "dudes4","Siwai","400","30","300"),
            Petani(user = "dudes5","Ajusshi","300","40","100")
        )
        petaniAdapter2 = PetaniAdapterCv(petani2)
        recyclerView2.apply { layoutManager = LinearLayoutManager(this@SampleCardView)
            adapter = petaniAdapter2
        }



    }
}