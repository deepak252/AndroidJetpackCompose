package com.example.jetpackcomposeapp.example1

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
    var count1 by rememberSaveable() {
        mutableStateOf(1)
    }
    var count2 by rememberSaveable() {
        mutableStateOf(1)
    }
    Log.d("MyTag","State updated")
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ){
        Column() {
//            Text(text = "$count")  // this approach leads to recomposition on state change
//            CustomText2(count = { count1 }) // Pass state as Lambda to avoid recomposition

            MultiText(
                count1 = { count1},
                count2 = {count2}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                count1++
            }) {
                Text(text = "Click1")
            }
            Button(onClick = {
                count2++
            }) {
                Text(text = "Click 2")
            }
        }
    }

}

@Composable
private fun MultiText(
    count1 : ()->Int,
    count2 : ()->Int,
){
    Column(

    ) {
        Spacer(modifier = Modifier.height(20.dp))
//        CustomText(count = count1())
        CustomText2(count = { count1() })
        Spacer(modifier = Modifier.height(20.dp))
        CustomText2(count = { count2() })
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun CustomText(count : Int){
    Text(
        text = "$count",
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable 
private fun CustomText2(count : ()->Int){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "${count()}"
    )
}