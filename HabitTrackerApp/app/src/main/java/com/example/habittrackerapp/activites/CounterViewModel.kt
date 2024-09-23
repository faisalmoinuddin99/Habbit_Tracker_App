package com.example.habittrackerapp.activites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    // Private MutableLiveData to manage state internally
    private val _counter = MutableLiveData(0)

    // Public immutable LiveData for external use
    val counter: LiveData<Int> = _counter

    fun incrementCounter() {
        // Updating the MutableLiveData
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun decrementCounter() {
        // Updating the MutableLiveData
        _counter.value = (_counter.value ?: 0) - 1
    }

    fun resetCounter() {
        _counter.value = 0
    }
}