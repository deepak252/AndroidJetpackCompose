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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import kotlinx.coroutines.delay


// 1. LaunchedEffect : Run sideEffects in control manner
@Composable
fun EffectScreen(){

    var users by rememberSaveable{
        mutableStateOf<List<String>>(listOf("User 5"))
    }

    var count by rememberSaveable{
        mutableStateOf(0)
    }
    Log.d("MyTag", "State Refresh")

//    users = fetchUsers()
    LaunchedEffect(key1 = count%4==0){
        // This Code will execute once for unique key1 value
        // LaunchedEffect uses CoroutineScope
        // Always called on Initial Composition
        // Cannot be called on Button Click etc.
//        delay(2000)
        Log.d("MyTag", "Fetch Users, count = $count")
        users = fetchUsers()
    }

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
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    items(users){
                        Text(
                            text = it,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                Button(onClick = {
//                    users = listOf("User A")
                    count++

                }) {
                    Text(text = "Set Users : count = $count")
                }
            }
        }
    }
}

fun fetchUsers(): List<String>{
    return List(100){
        "User ${it+1}"
    }
}