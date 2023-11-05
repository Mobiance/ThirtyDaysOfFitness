@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.thirtydaysoffitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysoffitness.model.ExcerciseRepository
import com.example.thirtydaysoffitness.ui.theme.ThirtyDaysOfFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfFitnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

@Composable
fun TopAppBar(
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 DAYS",
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
fun ThirtyDaysApp(){
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        val excercises = ExcerciseRepository.Excercises
        ExcerciseList(excercises = excercises, contentPadding = it)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirtyDaysOfFitnessTheme {
        TopAppBar()
    }
}