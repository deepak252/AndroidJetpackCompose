package com.example.jetpackcomposeapp.utils

sealed class Screen(val route : String){
    object FirstScreen : Screen("FirstScreen")
    object SecondScreen : Screen("SecondScreen")
    object ThirdScreen : Screen("{data}/ThirdScreen"){
        fun createRoute(data : String) = "$data/ThirdScreen"  // to get data
    }
}
