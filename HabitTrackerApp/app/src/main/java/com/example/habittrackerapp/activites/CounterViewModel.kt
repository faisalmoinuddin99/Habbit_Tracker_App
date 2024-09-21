package com.example.habittrackerapp.activites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counter = mutableIntStateOf(0)
        private set

    fun incrementCounter() {
        counter.intValue++
    }

    fun decrementCounter() {
        counter.intValue--
    }
}