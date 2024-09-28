package com.example.habittrackerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {

    private val _data = MutableLiveData<Int>()
    val data: LiveData<Int> get() = _data

    fun onIncrement() {
        viewModelScope.launch {
            delay(1000L)
            _data.value = (_data.value ?: 0) + 1
        }
    }

    fun onDecrement() {
        viewModelScope.launch {
            delay(1000L)
            _data.value = (_data.value ?: 0) - 1
        }
    }
}