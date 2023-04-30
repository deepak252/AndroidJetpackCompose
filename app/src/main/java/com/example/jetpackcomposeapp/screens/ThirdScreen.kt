package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme


data class ThirdScreen(val data : String) : Screen{
    @Composable
    override fun Content(){
        JetpackComposeAppTheme() {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "$data Third Screen"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
//                    Button(onClick = {
//                    }) {
//                        Text(text = "Go To Second Screen")
//                    }
                }
            }
        }
    }

}