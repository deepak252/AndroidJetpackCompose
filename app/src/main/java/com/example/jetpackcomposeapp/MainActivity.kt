package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationScreen()
        }
    }
}

@Composable
fun NotificationScreen(){
    val state = rememberSaveable{
        mutableStateOf(0)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        // Hoisting
        NotificationCounter(state.value) {
            state.value++
        }
        CounterText(
            state.value,

        )
    }
}


@Composable
fun NotificationCounter(count : Int, onClick : ()->Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            count.toString(),
            fontSize = 24.sp
        )
        Button(onClick) {
            Text("Increment")
        }
    }
}

@Composable
fun CounterText(count : Int){
    Text(
        "Counter : ${count.toString()}"
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewNotificationScreen(){
    NotificationScreen()
}

