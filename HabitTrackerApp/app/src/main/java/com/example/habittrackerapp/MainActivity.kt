package com.example.habittrackerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.habittrackerapp.activites.CounterViewModel
import com.example.habittrackerapp.ui.theme.HabitTrackerAppTheme

class MainActivity : ComponentActivity() {


    private val counterViewModel : CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Parent(
                        modifier = Modifier.padding(innerPadding),
                        paramViewModel = counterViewModel
                    )
                }
            }
        }
    }
}



@Composable
fun Parent(modifier: Modifier, paramViewModel: CounterViewModel) {


    var count by paramViewModel.counter


    Child(
        onIncrement = { paramViewModel.incrementCounter()},
        count = count,
        onReset = { count = 0 },
        onDecrement = {
            if (count > 0) paramViewModel.decrementCounter()
        })

}

@Composable
fun Child(
    onIncrement: () -> Unit,
    count: Int,
    onReset: () -> Unit,
    onDecrement: () -> Unit
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count $count")
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onIncrement() }) {
                Text(text = "+")
            }
            Button(onClick = { onReset() }) {
                Text(text = "Reset")
            }
            Button(onClick = { onDecrement() }) {
                Text(text = "-")
            }
        }
    }

}