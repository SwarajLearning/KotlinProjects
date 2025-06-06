package com.example.counterapp

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {


    private val _counter: MutableLiveData<Int> = MutableLiveData(0)
    val counter: MutableLiveData<Int> get() = _counter


    fun increaseCounter(view: View) {
        val currentValue = _counter.value

        _counter.value = currentValue?.plus(1)
    }

//    fun getCounter() : MutableLiveData<Int> {
//        return _counter
//    }

}