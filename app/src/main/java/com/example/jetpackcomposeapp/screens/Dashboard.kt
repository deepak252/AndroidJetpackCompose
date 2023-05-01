package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.navgraphs.BottomNavHost
import com.example.jetpackcomposeapp.navgraphs.BottomNavItem

@Composable
fun Dashboard(navController: NavHostController = rememberNavController()) {
//    val bottomNavItems = listOf(
//        BottomNavItem.Home,
//        BottomNavItem.Favorites,
//        BottomNavItem.Profile,
//    )

    Scaffold(
        bottomBar = { BottomNavBar(navController)}

    ){paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))    {
            BottomNavHost(navController = navController)
        }
    }

//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier.height(70.dp)
//            ) {
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentDestination = navBackStackEntry?.destination
//                bottomNavItems.forEach{item->
//                    IconButton(onClick = {
//                        navController.navigate(item.route) {
//                            // Pop up to the start destination of the graph to
//                            // avoid building up a large stack of destinations
//                            // on the back stack as users select items
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//                            // Avoid multiple copies of the same destination when
//                            // reselecting the same item
//                            launchSingleTop = true
//                            // Restore state when reselecting a previously selected item
//                            restoreState = true
//                        }
//                    }) {
//                        Icon( item.icon, contentDescription = item.title)
//                    }
//
//                }
//            }
//        }
//    ) {paddingValues ->
//        Box(modifier = Modifier.padding(paddingValues))    {
////            AppNavHost(navController =navController)
//        }
//    }


}

@Composable
fun BottomNavBar(navController : NavController){
    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Profile,
    )

    BottomAppBar(
        modifier = Modifier.height(70.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        bottomNavItems.forEach{item->
            IconButton(onClick = {
                navController.navigate(item.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }) {
                Icon( item.icon, contentDescription = item.title)
            }

        }
    }
}