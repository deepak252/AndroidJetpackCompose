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
import androidx.navigation.NavHostController
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import com.example.jetpackcomposeapp.utils.Screen

@Composable
fun SecondScreen(
    navHostController: NavHostController
){
    JetpackComposeAppTheme() {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Second Screen")
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    navHostController.navigate(Screen.ThirdScreen.route){
//                        popUpTo(Screen.FirstScreen.route) // on back press in third screen -> redirect to First Screen
//                        popUpTo(Screen.FirstScreen.route){
//                            inclusive=true  // Pop all screens
//                        }
                    }
                }) {
                    Text(text = "Go To Third Screen")
                }

                Button(onClick = {
                    navHostController.navigate(Screen.ThirdScreen.createRoute("Hello"))
                }) {
                    Text(text = "Send Data to Third Screen")
                }
            }
        }
    }
}