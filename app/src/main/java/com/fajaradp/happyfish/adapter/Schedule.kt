package com.fajaradp.happyfish.adapter

import android.content.Context
import android.transition.Scene
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fajaradp.happyfish.R
import com.fajaradp.happyfish.model.DataReport
import java.text.SimpleDateFormat
import java.util.*

class Schedule (
    private var listData: List<DataReport>,
    private val context: Context,

) : RecyclerView.Adapter<Schedule.MainViewHolder>() {
    class MainViewHolder (view: View): RecyclerView.ViewHolder(view){
        val Waktu: TextView = view.findViewById(R.id.tanggal)
        val Ket: TextView = view.findViewById(R.id.keterangan)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]
        data?.let {
            val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            var calendar = Calendar.getInstance()
            holder.Waktu.text = formatter.format(data.waktu!!.toDate())
            holder.Ket.text = data.keterangan
        }



    }

}