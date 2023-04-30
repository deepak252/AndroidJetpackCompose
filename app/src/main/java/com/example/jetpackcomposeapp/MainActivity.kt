package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.jetpackcomposeapp.components.tabs.FavoritesTab
import com.example.jetpackcomposeapp.components.tabs.HomeTab
import com.example.jetpackcomposeapp.components.tabs.ProfileTab
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppTheme() {
                Surface {
                    Content()
                }
            }
        }
    }

    @Composable
    fun Content(){
        TabNavigator(tab = HomeTab){
            Scaffold(
                bottomBar = {
                    BottomNavigation() {
                        TabNavigationItem(tab = HomeTab)
                        TabNavigationItem(tab = FavoritesTab)
                        TabNavigationItem(tab = ProfileTab)
                    }
                }
            ) {paddingValues ->
                Box(modifier = Modifier.padding(paddingValues))  {
                    CurrentTab()
                }
            }
        }
    }

    @Composable
    fun RowScope.TabNavigationItem(tab : Tab){
        val tabNavigator = LocalTabNavigator.current
        BottomNavigationItem(
            selected = tabNavigator.current==tab,
            onClick = {
                      tabNavigator.current=tab
                      },
            icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }

        )
    }
}
