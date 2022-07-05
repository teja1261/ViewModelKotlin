package com.example.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class MainViewActivity: ViewModel() {
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun incrementCount() {
        count.value = (count.value)?.plus(1)
        Log.d("COUNT", count.toString())

    }

    fun decrementCount() {
        count.value = (count.value)?.minus(1)
    }
}