package com.example.arithmeticcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.arithmeticcalculator.ui.theme.ArithmeticCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArithmeticCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    Mathematics()
                }
                }
            }
        }
    }


@Composable
fun Mathematics() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0f) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Number1") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Number2") },
            modifier = Modifier.fillMaxWidth()
        )

    Row(
        modifier = Modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = {
                error = null
                val value1 = num1.toFloatOrNull()
                val value2 = num2.toFloatOrNull()

                if (num1.isEmpty() or num2.isEmpty()) {
                    error = "Error: Please put in input!"
                } else if (value1 == null || value2 == null) {
                    error = "Error: Invalid input!"
                }
                else {
                    result = Addition(num1.toFloat(), num2.toFloat())
                }
            }
        ) {
            Text("+")
        }

        Button(
            onClick = {
                error = null
                val value1 = num1.toFloatOrNull()
                val value2 = num2.toFloatOrNull()

                if (num1.isEmpty() || num2.isEmpty()) {
                    error = "Error: Please put in input!"
                } else if (value1 == null || value2 == null) {
                    error = "Error: Invalid input!"
                }
                else{
                    result = Multiple(num1.toFloat(), num2.toFloat())
                }
            }
        ) {
            Text("*")
        }

        Button(
            onClick = {
                error = null
                val value1 = num1.toFloatOrNull()
                val value2 = num2.toFloatOrNull()

                if (num1.isEmpty() || num2.isEmpty()) {
                    error = "Error: Please put in input!"
                } else if (value1 == null || value2 == null) {
                    error = "Error: Invalid input!"
                }
                else {
                    result = Subtract(num1.toFloat(), num2.toFloat())
                }
            }
        ) {
            Text("-")
        }

        Button(
            onClick = {
                error = null
                val value1 = num1.toFloatOrNull()
                val value2 = num2.toFloatOrNull()

                if (num1.isEmpty() || num2.isEmpty()) {
                    error = "Error: Please put in input!"
                } else if (value1 == null || value2 == null) {
                    error = "Error: Invalid input!"
                }
                else if (num2.toFloat() == 0f || num1.toFloat() == 0f && num2.toFloat() == 0f) {
                    error = "Error: Division by 0 error!"
                }

                else{
                    result = Dividee(num1.toFloat(), num2.toFloat())
                }
            }
        ) {
            Text("/")
        }

        Button(
            onClick = {
                error = null
                val value1 = num1.toFloatOrNull()
                val value2 = num2.toFloatOrNull()

                if (num1.isEmpty() || num2.isEmpty()) {
                error = "Error: Please put in input!"
            } else if (value1 == null || value2 == null) {
                error = "Error: Invalid input!"
                }

                else if (num2.toFloat() == 0f || num1.toFloat() == 0f && num2.toFloat() == 0f) {
                    error = "Error: Modulus by 0 error!"
                }
                    else
                 {
                    result = Modulus(num1.toFloat(), num2.toFloat())
                }
            }
        ) {
            Text("%")
        }
    }
        result?.let { Text(text = "Result: ${result}") }
        error?.let { Text(it, color = Color.Red) }
}

}

fun Addition(x1: Float, x2: Float): Float{
    return x1 + x2
}

fun Multiple(x1:Float, x2: Float): Float {
    return x1 * x2
}

fun Subtract(x1: Float, x2: Float): Float {
    return x1 - x2
}

fun Dividee(x1: Float, x2: Float): Float {
    return x1 / x2
}

fun Modulus(x1: Float, x2: Float): Float {
    return x1 % x2
}