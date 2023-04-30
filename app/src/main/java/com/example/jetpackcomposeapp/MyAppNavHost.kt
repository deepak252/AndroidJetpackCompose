package com.example.jetpackcomposeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.screens.FirstScreen
import com.example.jetpackcomposeapp.screens.SecondScreen
import com.example.jetpackcomposeapp.screens.ThirdScreen
import com.example.jetpackcomposeapp.utils.Screen

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDest: String = Screen.FirstScreen.route
){
//    NavHost(
//        navController = navController,
//        startDestination = startDest
//    )
    NavHost(
        navController = navController,
        startDestination = startDest
    ){
        composable( Screen.FirstScreen.route ){
            FirstScreen(navHostController = navController)
        }
        composable( Screen.SecondScreen.route ){
            SecondScreen(navHostController = navController)
        }
        composable( Screen.ThirdScreen.route ){
            var data = it.arguments?.getString("data") // key=data (to et data)
            ThirdScreen(data)
        }
    }


}