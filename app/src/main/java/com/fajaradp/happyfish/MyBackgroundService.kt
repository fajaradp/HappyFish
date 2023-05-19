package com.fajaradp.happyfish

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyBackgroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this,"Running",Toast.LENGTH_SHORT).show()
        // Lakukan tugas atau pemrosesan di background di sini
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
