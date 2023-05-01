package com.example.jetpackcomposeapp.navgraphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.screens.Dashboard
import com.example.jetpackcomposeapp.screens.SplashScreen


@Composable
fun RootNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDest: String = Screen.Splash.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDest
    ){
        composable(
            route = Screen.BottomNav.route
        ){
            Dashboard()
        }

        composable(
            route = Screen.Splash.route
        ){
            SplashScreen( navController)
        }
    }
}

sealed class Screen(val route : String) {
    object Splash : Screen("splash")
    object BottomNav : Screen("bottomNav")
}


