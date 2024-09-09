package com.example.habbittracker.custom_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habbittracker.data.Habit
import com.example.habbittracker.data.HabitDao
import kotlinx.coroutines.launch

/*
TODO - Explanation:

    HabitViewModel manages the data and communicates with HabitDao.
    Functions addHabit(), updateHabit(), and deleteHabit() are used to perform operations on habits.
 */

class HabitViewModel(private val habitDao: HabitDao) : ViewModel() {
    val allHabits = habitDao.getAllHabits()

    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            habitDao.insertHabit(habit)
        }
    }

    fun updateHabit(habit: Habit) {
        viewModelScope.launch {
            habitDao.updateHabit(habit)
        }
    }

    fun deleteHabit(habit: Habit) {
        viewModelScope.launch {
            habitDao.deleteHabit(habit)
        }
    }
}