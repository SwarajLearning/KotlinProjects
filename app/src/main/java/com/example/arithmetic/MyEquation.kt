package com.example.arithmetic

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.arithmetic.databinding.ActivityMainBinding

class MyEquation(private val activityMainBinding: ActivityMainBinding) : BaseObservable() {

    @Bindable
    var number1: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.number1)
        }

    @Bindable
    var number2: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.number2)
        }

    @Bindable
    var result: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.result)
        }



    fun solveArithmetic(view: View) {
        val number1 = number1.toIntOrNull()
        val number2 = number2.toIntOrNull()
        var result = result.toIntOrNull()

        if (number1 != null && number2 != null) {
            result = number1 + number2
        }

        activityMainBinding.tvResult.text = result.toString()
    }

}