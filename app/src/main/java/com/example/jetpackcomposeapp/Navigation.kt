package com.example.jetpackcomposeapp

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import com.example.jetpackcomposeapp.screens.FirstScreen
import com.example.jetpackcomposeapp.screens.SecondScreen
import com.example.jetpackcomposeapp.screens.ThirdScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    navController : NavHostController = rememberAnimatedNavController()
) {
    AnimatedNavHost(
        navController,
        startDestination = ScreenRoutes.FirstScreen.route

    ){
        composable(
            route = ScreenRoutes.FirstScreen.route,
            enterTransition = {
                // When this screen(First) get pushed.
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(400)
                )
//                EnterTransition.None
            },
            exitTransition = {
                // When another screen(SecondScreen) gets pushed to this screen
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(400)
                )
//                ExitTransition.None
            },
            popEnterTransition = {
                // When another screen(SecondScreen) gets popped from this screen
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(400)
                )
//                EnterTransition.None
            },
            popExitTransition = {
                //when pop back to previous screen (__)
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(400)
                )
//                ExitTransition.None
            },

        ){
            FirstScreen(
                onButtonClick = {
                    navController.navigate(ScreenRoutes.SecondScreen.route)
                }
            )
        }
        composable(
            route = ScreenRoutes.SecondScreen.route,
            enterTransition = {
                // When this screen(SecondScreen) get pushed.
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(400)
                )
//                EnterTransition.None
            },
            exitTransition = {
                // When another screen(ThirdScreen) gets pushed to this screen
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(400)
                )
//                ExitTransition.None
            },
            popEnterTransition = {
                // When another screen(ThirdScreen) gets popped from this screen
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(400)
                )
//                EnterTransition.None
            },
            popExitTransition = {
                //when pop back to previous screen (FirstScreen)
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(400)
                )
//                ExitTransition.None
            },

        ){
            SecondScreen(
                onButtonClick = {
                    navController.navigate(ScreenRoutes.ThirdScreen.route)
                }
            )
        }
        composable(
            route = ScreenRoutes.ThirdScreen.route,
            enterTransition = {
                // When this screen(ThirdScreen) get pushed.
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(400)
                )
//                EnterTransition.None
            },
            exitTransition = {
                // When another screen(__) gets pushed to this screen
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(400)
                )
//                ExitTransition.None
            },
            popEnterTransition = {
                // When another screen(__) gets popped from this screen
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(400)
                )
//                EnterTransition.None
            },
            popExitTransition = {
                //when pop back to previous screen (SecondScreen)
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(400)
                )
//                ExitTransition.None
            },
        ){
            ThirdScreen(
            )
        }

    }

}

sealed class ScreenRoutes(val route : String){
    object FirstScreen : ScreenRoutes("firstScreen")
    object SecondScreen : ScreenRoutes("secondScreen")
    object ThirdScreen : ScreenRoutes("thirdScreen")
}



//    AnimatedNavHost(
//        navController,
//        startDestination = ScreenRoutes.FirstScreen.route,
//        enterTransition = {
//            slideInHorizontally(animationSpec = tween(400))
//        },
//        exitTransition = {
//            ExitTransition.None
//        },
//        popEnterTransition = {
//            EnterTransition.None
//        },
//        popExitTransition = {
//            ExitTransition.None
//        },
//
//    ){
//        composable(
//            route = ScreenRoutes.FirstScreen.route,
//
//
//        ){
//            FirstScreen(
//                onButtonClick = {
//                    navController.navigate(ScreenRoutes.SecondScreen.route)
//                }
//            )
//        }
//        composable(
//            route = ScreenRoutes.SecondScreen.route,
//
//
//        ){
//            SecondScreen(
//                onButtonClick = {
//                    navController.navigate(ScreenRoutes.ThirdScreen.route)
//                }
//            )
//        }
//        composable(
//            route = ScreenRoutes.ThirdScreen.route,
//
//        ){
//            ThirdScreen(
//            )
//        }
//
//    }