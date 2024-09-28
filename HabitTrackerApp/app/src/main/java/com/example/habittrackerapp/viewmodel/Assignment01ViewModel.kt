package com.example.habittrackerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Assignment01ViewModel : ViewModel() {

    private val _display = MutableLiveData<Boolean>(false)
     val display: LiveData<Boolean> get() = _display
    
    fun toggleBox(){
        viewModelScope.launch {
            // Safely update the MutableLiveData _display
            delay(1000L)
            _display.value = _display.value?.let { !it } ?: true
        }
    }
}