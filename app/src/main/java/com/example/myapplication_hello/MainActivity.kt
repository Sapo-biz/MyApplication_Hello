package com.example.myapplication_hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication_hello.ui.theme.MyApplication_HelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication_HelloTheme {
                GreetingScreen()
            }
        }
    }
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    val clickCount = remember { mutableIntStateOf(0) }

    val isInitial = clickCount.intValue == 0
    val backgroundColor = when {
        isInitial -> Color.White
        clickCount.intValue % 2 == 1 -> Color.Red
        else -> Color.Green
    }
    val greetingText = if (isInitial) "Hello Jason!" else "Hello word!"

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = greetingText)
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { clickCount.intValue += 1 }
            ) {
                Text(text = "Change Color")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication_HelloTheme {
        GreetingScreen()
    }
}