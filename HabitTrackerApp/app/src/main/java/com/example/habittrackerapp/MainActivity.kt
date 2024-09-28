package com.example.habittrackerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habittrackerapp.roughwork.Assignment01
import com.example.habittrackerapp.ui.theme.HabitTrackerAppTheme
import com.example.habittrackerapp.viewmodel.Assignment01ViewModel
import com.example.habittrackerapp.viewmodel.CounterViewModel
import com.example.habittrackerapp.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    private val userViewModel: UserViewModel by viewModels()
    private val assignment01ViewModel: Assignment01ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
//                    UserListScreen(userViewModel)
                    Assignment01(assignment01ViewModel)
                }
            }
        }
    }
}

@Composable
fun ParentCounter(modifier: Modifier, myCounterViewModel: CounterViewModel = viewModel()) {

    val counter by myCounterViewModel.data.observeAsState(0)
    HelperCounter(
        onDecrement = {
            myCounterViewModel.onDecrement()
        },
        count = counter,
        onIncrement = {
            myCounterViewModel.onIncrement()
        }
    )
}

@Composable
fun HelperCounter(
    onIncrement: () -> Unit,
    count: Int = 0,
    onDecrement: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onIncrement() }) {
                Text(text = "+")
            }
            Text(text = "Counter $count")
            Button(onClick = { onDecrement() }) {
                Text(text = "-")
            }

        }
    }
}