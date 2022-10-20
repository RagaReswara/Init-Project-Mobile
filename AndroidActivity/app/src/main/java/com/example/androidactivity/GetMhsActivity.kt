package com.example.androidactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidactivity.adapter.MahasiswaAdapter
import com.example.androidactivity.model.ResponseMahasiswaItem
import com.example.androidactivity.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMhsActivity : AppCompatActivity() {

    lateinit var rvGetMhs   : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_mhs)

        rvGetMhs = findViewById(R.id.rvGetMhs)

        NetworkConfig().getService()
            .getMhs()
            .enqueue(object : Callback<List<ResponseMahasiswaItem>> {
                override fun onFailure(call: Call<List<ResponseMahasiswaItem>>, t:
                Throwable) {
                    Toast.makeText(this@GetMhsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<List<ResponseMahasiswaItem>>,
                    response: Response<List<ResponseMahasiswaItem>>
                ) {
                    rvGetMhs.apply{
                        layoutManager = LinearLayoutManager(this@GetMhsActivity)
                        adapter = MahasiswaAdapter.MahasiswaAdapter(response.body())
                    }
                }
            })

    }
}