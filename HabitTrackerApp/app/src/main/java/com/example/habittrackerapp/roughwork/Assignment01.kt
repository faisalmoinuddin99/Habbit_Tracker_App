package com.example.habittrackerapp.roughwork

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.habittrackerapp.viewmodel.Assignment01ViewModel

@Composable
fun Assignment01(assignment01ViewModel: Assignment01ViewModel) {
    HelperAssignment01(assignment01ViewModel)
}


@Composable
fun HelperAssignment01(
    assignment01ViewModel: Assignment01ViewModel  // Use viewModel for proper lifecycle management
) {
    // Observe LiveData from ViewModel
    val display by assignment01ViewModel.display.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Add padding for better spacing
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Row to display the Boxes
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Conditionally display Box1 or Box2 based on `display` state
            if (display) {
                Box1()
            } else {
                Box2()
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Add some space between the boxes and the button

        // Button to toggle the state
        Button(onClick = { assignment01ViewModel.toggleBox() }) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun Box1() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(4.dp))
            .background(Color.LightGray)
    ) {
        // Centered Text inside Box1
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BOX 01")
        }
    }
}

@Composable
fun Box2() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(4.dp))
            .background(Color.Yellow)
    ) {
        // Centered Text inside Box2
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BOX 02")
        }
    }
}