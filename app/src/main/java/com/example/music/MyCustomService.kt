package com.example.music

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MyCustomService: Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.getBooleanExtra("crash", false) == true) {
            Log.e("MyCustomService", "Simulating crash now!")
            throw RuntimeException("Simulated Crash")
        }

        mediaPlayer = MediaPlayer.create(
            this,
            Settings.System.DEFAULT_RINGTONE_URI
        )

        mediaPlayer.isLooping = true

        mediaPlayer.start()

        if (intent == null) {
            Log.e("MyCustomService", "Service restarted by system: Intent is null")
        } else {
            Log.e("MyCustomService", "Service started manually: Intent is NOT null")
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("MyCustomService", "Service destroyed, stopping MediaPlayer")
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}