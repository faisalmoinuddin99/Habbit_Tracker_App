package com.example.habbittracker.custom_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// dummy data for demo purpose
val habits = listOf(
    "Exercise",
    "Meditation",
    "Reading",
    "Journaling",
    "Coding"
)

// Main Composable function to display the Habit List Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitListScreen() {
    // Scaffold provides a basic layout structure with optional top, bottom, or side components
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Habit Tracker") }) // Top app bar with title
        }
    ) { padding ->
        // Main content of the screen wrapped in a Column
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            // Display habits in a LazyColumn (similar to RecyclerView in traditional Android)
            LazyColumn {
                // Display each habit as a card
                items(habits) { habit ->
                    HabitCard(habitName = habit)
                }
            }
        }
    }
}


// Composable function to display a single Habit Card
@Composable
fun HabitCard(habitName: String) {
    Card(
        modifier = Modifier.fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        // Habit name displayed inside the card with padding
        Text(
            text = habitName,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}