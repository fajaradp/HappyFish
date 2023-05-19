package com.fajaradp.happyfish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fajaradp.happyfish.adapter.Schedule
import com.fajaradp.happyfish.model.DataReport
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase

class ScheduleActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance().collection("Record")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        val datarecycler : RecyclerView = findViewById(R.id.rv_record)
        datarecycler.layoutManager = LinearLayoutManager(this)
        db.orderBy("waktu", Query.Direction.DESCENDING).get().addOnSuccessListener{
            val data = it.toObjects(DataReport::class.java)
            val adapter = Schedule(data,this@ScheduleActivity)
            datarecycler.adapter = adapter
            datarecycler.visibility = View.VISIBLE

        }.addOnFailureListener {
            datarecycler.visibility = View.INVISIBLE
        }





        val SBack : Toolbar = findViewById(R.id.stoolbar)

        SBack.setNavigationOnClickListener{
            finish()
        }

    }
}