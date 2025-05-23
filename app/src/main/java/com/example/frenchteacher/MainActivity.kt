package com.example.frenchteacher

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btBlack: Button
    private lateinit var btYellow: Button
    private lateinit var btGreen: Button
    private lateinit var btPurple: Button
    private lateinit var btRed: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btBlack = findViewById(R.id.btBlack)
        btYellow = findViewById(R.id.btYellow)
        btGreen = findViewById(R.id.btGreen)
        btPurple = findViewById(R.id.btPurple)
        btRed = findViewById(R.id.btRed)

        btBlack.setOnClickListener(this)
        btYellow.setOnClickListener(this)
        btGreen.setOnClickListener(this)
        btPurple.setOnClickListener(this)
        btRed.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id?.equals(R.id.btBlack) == true) {
            playSounds(R.raw.black)
        } else if (view?.id?.equals(R.id.btYellow) == true) {
            playSounds(R.raw.yellow)
        } else if (view?.id?.equals(R.id.btPurple) == true) {
            playSounds(R.raw.purple)
        } else if (view?.id?.equals(R.id.btRed) == true) {
            playSounds(R.raw.red)
        } else if (view?.id?.equals(R.id.btGreen) == true) {
            playSounds(R.raw.green)
        }
    }

    private fun playSounds(id: Int) {
        val mediaPlayer = MediaPlayer.create(applicationContext, id)
        mediaPlayer.start()
    }
}