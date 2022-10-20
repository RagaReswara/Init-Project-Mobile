package com.example.androidactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidactivity.R
import com.example.androidactivity.model.ResponseMahasiswaItem

class MahasiswaAdapter {

    class MahasiswaAdapter(val mhs: List<ResponseMahasiswaItem>?):
        RecyclerView.Adapter<MahasiswaAdapter.MahasiswaHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MahasiswaAdapter.MahasiswaHolder {
            return(
              MahasiswaHolder(
              LayoutInflater.from(parent.context).inflate(R.layout.rv_mhs_api, parent, false)))
        }
        override fun onBindViewHolder(holder: MahasiswaAdapter.MahasiswaHolder,
                                      position: Int) {
            holder.bindMhs(mhs?.get(position))
        }
        override fun getItemCount(): Int {
            return mhs?.size ?: 0
        }
        class MahasiswaHolder(view: View) : RecyclerView.ViewHolder(view) {
            lateinit var txtIdMhs       : TextView
            lateinit var txtNamaMhs     : TextView
            lateinit var txtNimMhs      : TextView
            lateinit var txtEmailMhs    : TextView
            lateinit var txtAlamatMhs   : TextView
            lateinit var txtFotoMhs     : TextView

            init
            {
                view.setOnLongClickListener{
                    val pop = PopupMenu(view.context,it)
                    pop.inflate(R.menu.menu_mhs)
                    pop.setOnMenuItemClickListener { item ->
                        when(item.itemId)
                        {
                            R.id.delete_mhs->{ }
                        }
                        true
                    }
                    pop.show()
                    true
                }
            }

            fun bindMhs(mhs: ResponseMahasiswaItem?) {
                itemView.apply {
                    txtIdMhs           = findViewById(R.id.txtGetIdMhs)
                    txtNamaMhs         = findViewById(R.id.txtGetNamaMhs)
                    txtNimMhs          = findViewById(R.id.txtGetNimMhs)
                    txtEmailMhs        = findViewById(R.id.txtGetEmail)
                    txtAlamatMhs       = findViewById(R.id.txtGetAlamatMhs)
                    txtFotoMhs         = findViewById(R.id.txtGetFotoMhs)

                    txtIdMhs.text      = mhs?.id.toString()
                    txtNamaMhs.text    = mhs?.nama
                    txtNimMhs.text     = mhs?.nim
                    txtEmailMhs.text   = mhs?.email
                    txtAlamatMhs.text  = mhs?.alamat
                    txtFotoMhs.text    = mhs?.foto
                }
            }
        }
    }
}