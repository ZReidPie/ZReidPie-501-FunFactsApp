package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactsapp.ui.theme.FunFactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FunFactsScreen(modifier: Modifier = Modifier) {
    // List of fun facts
    val facts = listOf(
        "Australia is wider than the moon.",
        "A group of flamingos is called a 'flamboyance'.",
        "Venus is the only planet to spin clockwise.",
        "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3000 years old!",
        "Octopuses have three hearts and blue blood.",
        "Wombat poop is cube-shaped.",
        "Allodoxaphobia is the fear of other people’s opinions.",
        "Lemons float, but limes sink.",
        "It would take 19 minutes to fall to the center of the Earth."
    )

    // State to hold the current fact
    var currentFactIndex by remember { mutableStateOf((facts.indices).random()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the current fun fact with styling
        Text(
            text = facts[currentFactIndex],
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Button to cycle to the next fact
        Button(onClick = {
            currentFactIndex = (currentFactIndex + 1) % facts.size
        }) {
            Text(text = "Next Fact")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactsScreenPreview() {
    FunFactsAppTheme {
        FunFactsScreen()
    }
}
