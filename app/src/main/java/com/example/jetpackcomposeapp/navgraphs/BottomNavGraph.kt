package com.example.jetpackcomposeapp.navgraphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.screens.FavoritesScreen
import com.example.jetpackcomposeapp.screens.HomeScreen
import com.example.jetpackcomposeapp.screens.ProfileScreen


@Composable
fun BottomNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
//    startDest: String = Screen.BottomNav.route
    startDest: String = BottomNavScreen.Home.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDest
    ){
//        bottomNavGraph(navController)

        composable( BottomNavScreen.Home.route ){
            HomeScreen(navController)
        }
        composable( BottomNavScreen.Favorites.route ){
            FavoritesScreen(navController)
        }
        composable( BottomNavScreen.Profile.route ){
            ProfileScreen(navController)
        }

    }
}


//private fun NavGraphBuilder.bottomNavGraph(
//    navController : NavController
//){
//    navigation(startDestination = BottomNavScreen.Home.route, route = Screen.BottomNav.route){

//        composable( BottomNavScreen.Home.route ){
//            HomeScreen(navController)
//        }
//        composable( BottomNavScreen.Favorites.route ){
//            FavoritesScreen(navController)
//        }
//        composable( BottomNavScreen.Profile.route ){
//            ProfileScreen(navController)
//        }
//    }
//}


sealed class BottomNavScreen(val route : String) {
    object Home : BottomNavScreen("${Screen.BottomNav.route}/home")
    object Favorites : BottomNavScreen("${Screen.BottomNav.route}/favorites")
    object Profile : BottomNavScreen("${Screen.BottomNav.route}/profile")
}


sealed class BottomNavItem(
    var route : String,
    var title : String,
    var selectedIcon : ImageVector,
    var icon : ImageVector,
) {
    object Home : BottomNavItem(
        BottomNavScreen.Home.route,
        "Home",
        Icons.Filled.Home,
        Icons.Outlined.Home,
    )
    object Favorites : BottomNavItem(
        BottomNavScreen.Favorites.route,
        "Favorites",
        Icons.Filled.Favorite,
        Icons.Outlined.FavoriteBorder,
    )
    object Profile : BottomNavItem(
        BottomNavScreen.Profile.route,
        "Profile",
        Icons.Filled.Person,
        Icons.Outlined.Person,
    )
}