package com.example.jetpackcomposeapp.example2

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

// Passing state as Lambda
@Composable
fun ExampleScreen2(){
    var exampleState2 = rememberExampleSate2()

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
        containerColor = Color.Black

    ) {paddingValues ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

        ){
            Column() {
    //            Text(text = "$count")  // this approach leads to recomposition on state change
                CustomText(count = { exampleState2.count }) // Pass state as Lambda to avoid recomposition
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    exampleState2.count++
                }) {
                    Text(text = "Click")
                }
            }
        }
    }


}

@Composable 
private fun CustomText(count : ()->Int){
    Text(
        text = "${count()}",
        style = TextStyle(
//            color = Color.DarkGray
        )
    )
}