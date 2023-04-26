package com.example.jetpackcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CustomTextField()
            RecomposableButton()
        }
    }
}

@Composable
fun CustomTextField(){
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = {
            state.value=it
        }
    )
}

@Preview()
@Composable
fun PreviewCustomTextField(){
    CustomTextField()
}


// Recomposition
@Composable
fun RecomposableButton(){
    Log.d("MyTag","Button Initial State (Initial Composition)")
    val state = remember {
        mutableStateOf(0.0)
    }
    Button(onClick = {
        state.value = Math.random()
    }) {
        Log.d("MyTag","Button State Changed (Composition & Recomposition)")
        Text(text = state.value.toString())
    }
}