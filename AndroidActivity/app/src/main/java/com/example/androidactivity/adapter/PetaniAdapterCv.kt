package com.example.androidactivity.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidactivity.R
import com.example.androidactivity.model.Petani

class PetaniAdapterCv (val petani: List<Petani>): RecyclerView.Adapter<PetaniAdapter.PetaniHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PetaniAdapter.PetaniHolder
    {
        return(
                PetaniHolderCv(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_dutatani, parent, false)))
    }
    override fun onBindViewHolder(holder: PetaniAdapter.PetaniHolder, position: Int)
    {
        holder.bindPetani(petani[position])
    }
    override fun getItemCount(): Int {
        return petani.size
    }

    class PetaniHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtUser: TextView
        lateinit var txtNama: TextView
        lateinit var txtJumlahLahan: TextView
        lateinit var txtIdentifikasi: TextView
        lateinit var txtTambahLahan: TextView
        fun bindPetani(petani: Petani) {
            itemView.apply {
                txtUser = findViewById(R.id.txtUser)
                txtNama = findViewById(R.id.txtNama)
                txtJumlahLahan = findViewById(R.id.txtJmlLahan)
                txtIdentifikasi = findViewById(R.id.txtIdentifikasi)
                txtTambahLahan = findViewById(R.id.txtTmbhLahan)
                txtUser.text = petani.user
                txtNama.text = petani.nama
                txtJumlahLahan.text = petani.jumlahLahan
                txtIdentifikasi.text = petani.identifikasi
                txtTambahLahan.text = petani.tambahLahan
            }
        }
    }
}