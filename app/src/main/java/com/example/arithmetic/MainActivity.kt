package com.example.arithmetic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.arithmetic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val equation = MyEquation(activityMainBinding)

        activityMainBinding.myEquation = equation
    }
}