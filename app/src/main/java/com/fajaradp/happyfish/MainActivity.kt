package com.fajaradp.happyfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.work.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Akuarium: CardView = findViewById(R.id.akuarium)
        Akuarium.setOnClickListener {
            val akuariumIntent = Intent(this@MainActivity, WaterActivity::class.java)
            startActivity(akuariumIntent)
        }
        val Pakan: CardView = findViewById(R.id.pakan)
        Pakan.setOnClickListener {
            val pakanIntent = Intent(this@MainActivity, FeederActivity::class.java)
            startActivity(pakanIntent)
        }
        val Informasi: CardView = findViewById(R.id.info)
        Informasi.setOnClickListener {
            val infoIntent = Intent(this@MainActivity, InfoActivity::class.java)
            startActivity(infoIntent)
        }
    }
}