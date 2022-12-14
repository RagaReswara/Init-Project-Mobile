package com.example.androidactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidactivity.R
import com.example.androidactivity.model.Petani

class PetaniAdapterCv (val petani: List<Petani>): RecyclerView.Adapter<PetaniAdapterCv.PetaniHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PetaniAdapterCv.PetaniHolder
    {
        return(
                PetaniHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_petani_adapter_cv, parent, false)))
    }
    override fun onBindViewHolder(holder: PetaniAdapterCv.PetaniHolder, position: Int)
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
                txtUser = findViewById(R.id.txtUserCv)
                txtNama = findViewById(R.id.txtNamaCv)
                txtJumlahLahan = findViewById(R.id.txtJmlLahanCv)
                txtIdentifikasi = findViewById(R.id.txtIdentifikasiCv)
                txtTambahLahan = findViewById(R.id.txtTmbhLahanCv)
                txtUser.text = petani.user
                txtNama.text = petani.nama
                txtJumlahLahan.text = petani.jumlahLahan
                txtIdentifikasi.text = petani.identifikasi
                txtTambahLahan.text = petani.tambahLahan
            }
        }
    }
}