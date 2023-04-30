package com.example.jetpackcomposeapp.screens

import android.util.Log
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

// 2. Using rememberCoroutineScope
@Composable
fun RememberCoroutineScope(){

    var count by rememberSaveable{
        mutableStateOf(0)
    }

    val coroutineScope = rememberCoroutineScope() // this scope is attach to the lifecycle of current Compose

//    LaunchedEffect(key1 = Unit){
////     Always called on Initial Composition
////     Cannot be called on Button Click etc.
//        Log.d("MyTag", "Counter Started..")
//        try {
//            for(i in 1..10){
//                count=i
//                delay(1000)
//            }
//        }catch (e : Exception){
//            //Rotate Screen -> Exception : StandaloneCoroutine was cancelled
//            Log.e("MyTag", "Exception : ${e.message}")
//        }
//    }

    JetpackComposeAppTheme(
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Count : $count",
                    modifier = Modifier.padding(8.dp)
                )
                Button(onClick = {
                    coroutineScope.launch {
                        Log.d("MyTag", "Coroutine Scope Counter Started..")
                        try {
                            for(i in 1..10){
                                count=i
                                delay(1000)
                            }
                        }catch (e : Exception){
                            //Rotate Screen -> Exception : StandaloneCoroutine was cancelled
                            Log.e("MyTag", "Exception : ${e.message}")
                        }
                    }

                }) {
                    Text(text = "Set Users : count = $count")
                }
            }
        }
    }
}
