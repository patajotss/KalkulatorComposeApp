package com.example.kalkulatorcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kalkulatorcomposeapp.ui.theme.KalkulatorComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KalkulatorComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KalkulatorScreen()
                }
            }
        }
    }
}

@Composable
fun KalkulatorScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            // Display screen for the calculator
            Text(
                text = "0", // Placeholder for the calculation result
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Button rows
            KalkulatorButtonRow(buttonLabels = listOf("7", "8", "9", "/"))
            KalkulatorButtonRow(buttonLabels = listOf("4", "5", "6", "x"))
            KalkulatorButtonRow(buttonLabels = listOf("1", "2", "3", "-"))
            KalkulatorButtonRow(buttonLabels = listOf("C", "0", "=", "+"))
        }
    }
}

@Composable
fun KalkulatorButtonRow(buttonLabels: List<String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        buttonLabels.forEach { label ->
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text(text = label)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KalkulatorComposeAppPreview() {
    KalkulatorComposeAppTheme {
        KalkulatorScreen()
    }
}