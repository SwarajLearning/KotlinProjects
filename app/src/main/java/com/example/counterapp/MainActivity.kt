package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var viewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModel = ViewModelProvider(this)[MyViewModel::class.java]


        activityMainBinding.viewModel = viewModel

        activityMainBinding.lifecycleOwner = this

//        viewModel.getCounter().observe(this) {
//            activityMainBinding.tvResult.text = it.toString()
//        }
    }
}