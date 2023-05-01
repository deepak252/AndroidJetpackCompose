package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposeapp.navgraphs.RootNavHost
import com.example.jetpackcomposeapp.screens.Dashboard

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootNavHost()
        }
    }
}
