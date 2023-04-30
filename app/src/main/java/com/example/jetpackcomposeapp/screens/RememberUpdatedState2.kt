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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

// 3. Remember function state
fun funcA(){ Log.d("MyTag", "Function A") }
fun funcB(){ Log.d("MyTag", "Function B") }

@Composable
fun RememberUpdatedState2(){
    var func by remember{
        mutableStateOf(::funcA)
    }
    LaunchedEffect(key1 = Unit,){
        delay(2000)
        func = ::funcB
    }

    Counter2(func)
}

@Composable
fun Counter2(func : ()->Unit) {
    val funcState by rememberUpdatedState(func)
    LaunchedEffect(key1 = Unit,){
        delay(5000)
        funcState()
    }
//    LaunchedEffect(key1 = Unit,){
//        delay(5000)
//        func()
//    }
    Text(text = "Update Function State")
}
