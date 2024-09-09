package com.example.habbittracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/*
TODO - Explanation:

    HabitDao defines the operations for interacting with the database.
    getAllHabits() returns all habits ordered by creation date.
 */
@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Query("SELECT * FROM habits ORDER BY createdDate DESC")
    fun getAllHabits(): Flow<List<Habit>>
}