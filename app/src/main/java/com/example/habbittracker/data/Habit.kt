package com.example.habbittracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
TODO - Explanation:

    This is the data model class for a habit.
    It has fields for id, name, description, isCompleted, and createdDate.

 */
@Entity(tableName = "habits")
data class Habit(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val isCompleted: Boolean = false,
    val createdDate: Long = System.currentTimeMillis()

)