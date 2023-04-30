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
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme


object FirstScreen : Screen{
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.currentOrThrow
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
                        text = "First Screen"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
//                        navigator push SecondScreen //infix function
//                        navigator+=SecondScreen //infix function
                        navigator.push(SecondScreen) //infix function
                    }) {
                        Text(text = "Go To Second Screen")
                    }
                }
            }
        }
    }

}