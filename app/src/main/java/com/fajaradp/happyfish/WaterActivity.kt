package com.fajaradp.happyfish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class WaterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        val database = Firebase.database
        val nilaiSuhu = database.getReference("Suhu")
        val nilaiPH = database.getReference("PH")

        val Suhu: TextView = findViewById(R.id.suhuAir)
        val PH: TextView = findViewById(R.id.phQuality)

        nilaiSuhu.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val suhu = p0.getValue(Double::class.java)
                val tempSuhu = String.format("%.1f", suhu)
                Suhu.text = tempSuhu.toString() + "°c"

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        nilaiPH.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p1: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val ph = p1.getValue(Double::class.java)
                val tempPh = String.format("%.2f", ph)
                PH.text = tempPh.toString()

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        val WBack : Toolbar = findViewById(R.id.wtoolbar)
        WBack.setNavigationOnClickListener{
            finish()
        }
    }
}