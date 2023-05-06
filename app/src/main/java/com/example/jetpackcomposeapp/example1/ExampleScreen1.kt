package com.example.jetpackcomposeapp.example1

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Passing state as Lambda
@Composable
fun ExampleScreen1(){
    var count by rememberSaveable() {
        mutableStateOf(1)
    }
    Log.d("MyTag","State updated")
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ){
        Column() {
//            Text(text = "$count")  // this approach leads to recomposition on state change
            CustomText(count = { count }) // Pass state as Lambda to avoid recomposition
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                count++
            }) {
                Text(text = "Click")
            }
        }
    }

}

@Composable 
private fun CustomText(count : ()->Int){
    Text(text = "${count()}")
}