package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Random

class SecondActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView
    private lateinit var tvLuckyNumber: TextView
    private lateinit var btShare: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvWelcome = findViewById(R.id.tvTitleluckyNumber)
        tvLuckyNumber = findViewById(R.id.tvLuckyNumber)
        btShare = findViewById(R.id.btShare);



        val userName = intent.getStringExtra("name")

        Log.d("SecondActivity", "Received username $userName")

        val randomNumber = generateRandomNumber()
        tvLuckyNumber.text = randomNumber.toString()

        btShare.setOnClickListener {
            shareData(userName, randomNumber)
        }

    }

    private fun generateRandomNumber() : Int {
        val random = Random()

        val upperLimit = 1000

        val randomNumberGenerated = random.nextInt(upperLimit)

        return randomNumberGenerated
    }


    private fun shareData(userName: String?, randomNumber: Int) {
        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "$userName got lucky")
        intent.putExtra(Intent.EXTRA_TEXT, "Lucky Number $randomNumber")

        startActivity(Intent.createChooser(intent, "Choose a Platform"))
    }
}