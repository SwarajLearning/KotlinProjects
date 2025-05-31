package com.example.music

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvTitleServiceApp: TextView
    private lateinit var btStartService: Button
    private lateinit var btCrashService: Button
    private lateinit var btStopService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvTitleServiceApp = findViewById(R.id.tvTitleServiceApp)
        btCrashService = findViewById(R.id.btCrashService)
        btStartService = findViewById(R.id.btStartService)
        btStopService = findViewById(R.id.btStopService)


        btCrashService.setOnClickListener{
            val serviceIntent = Intent(this, MyCustomService::class.java)
            serviceIntent.putExtra("crash", true)
            startService(serviceIntent)
        }

        btStartService.setOnClickListener{
            val serviceIntent = Intent(this, MyCustomService::class.java)
            startService(serviceIntent)
        }

        btStopService.setOnClickListener{
            val serviceIntent = Intent(this, MyCustomService::class.java)
            stopService(serviceIntent)
        }
    }
}