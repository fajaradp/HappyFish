package com.fajaradp.happyfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FeederActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeder)

        val database = Firebase.database
        val myRef = database.getReference("BeriPakan")
        val jmlPakan = database.getReference("Nilai persen")


        val Jadwal: FloatingActionButton = findViewById(R.id.fabSchedule)
        Jadwal.setOnClickListener {
            val jadwalIntent = Intent(this@FeederActivity, ScheduleActivity::class.java)
            startActivity(jadwalIntent)


        }
        val Feeders: TextView = findViewById(R.id.feeders)
        val BtnPakan : Button = findViewById(R.id.btnPakan)

        BtnPakan.setOnClickListener{
            myRef.setValue("1")

        }
        jmlPakan.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val pakan = snapshot.getValue(Int::class.java)
                Feeders.text = pakan.toString() + "%"

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

        val FBack : Toolbar = findViewById(R.id.ftoolbar)
        FBack.setNavigationOnClickListener{
            finish()
        }

    }
}