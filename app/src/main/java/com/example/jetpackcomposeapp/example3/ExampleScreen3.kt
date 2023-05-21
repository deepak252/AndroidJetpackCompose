package com.example.jetpackcomposeapp.example3

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

// Passing state as Lambda
@Composable
fun ExampleScreen3(
    exampleViewModel3: ExampleViewModel3 = ExampleViewModel3()
){
    var exampleState2 = rememberExampleSate3()
    val viewModelState = exampleViewModel3

    LaunchedEffect(key1 = exampleState2.shouldShowSnackbar){
        Log.d("MyTag", "Launched Effect, show snackbar = ${exampleState2.shouldShowSnackbar}")
        if(exampleState2.shouldShowSnackbar){
            exampleState2.showSnackbar("Show Snack Bar")
        }
    }

    Log.d("MyTag","State updated")
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = exampleState2.snackbarState)
        },
        containerColor = Color.Transparent

    ) {paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

        ){
            Column() {
                CustomText(value = {
                    viewModelState
                }) // Pass state as Lambda to avoid recomposition
                Spacer(modifier = Modifier.height(20.dp))
    //            Text(text = "$count")  // this approach leads to recomposition on state change
                CustomText(value = { exampleState2.count }) // Pass state as Lambda to avoid recomposition
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    exampleState2.count++
                    exampleViewModel3.setValue("Updated Value")
                }) {
                    Text(text = "Click")
                }
            }
        }
    }
}

@Composable 
private fun CustomText(value : ()->Any){
    Text(
        text = "${value()}",
        style = TextStyle(
//            color = Color.DarkGray
        )
    )
}