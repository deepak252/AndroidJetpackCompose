package com.example.jetpackcomposeapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.navgraphs.BottomNavHost
import com.example.jetpackcomposeapp.navgraphs.BottomNavItem

@Composable
fun Dashboard(navController: NavHostController = rememberNavController()) {

    Scaffold(
        bottomBar = { BottomNavBar(navController)},
    ){paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))    {
            BottomNavHost(navController = navController)
        }
    }
}

@Composable
private fun BottomNavBar(navController : NavController){
    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
//            .fillMaxHeight(.1f)
            .padding(
                horizontal = 12.dp, vertical = 12.dp
            )
            .clip(RoundedCornerShape(12.dp))
            ,
        tonalElevation = 12.dp,
    ) {
        bottomNavItems.forEach{item->
            val selected = currentDestination?.hierarchy?.any {
                it.route == item.route
            } == true
            NavigationBarItem(
                selected = selected,
                alwaysShowLabel = false,
                onClick = {
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
                },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
            )
        }
    }

}