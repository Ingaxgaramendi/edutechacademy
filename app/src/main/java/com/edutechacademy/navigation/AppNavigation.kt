// ============================================
// AppNavigation.kt
// ============================================

package com.edutechacademy.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.edutechacademy.screens.CoursesDetailScreen
import com.edutechacademy.screens.CoursesScreen
import com.edutechacademy.screens.HomeScreen
import com.edutechacademy.screens.LoginScreen
import com.edutechacademy.screens.ProfileScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(navController)
        }

        composable("home") {

            HomeScreen(navController)
        }

        composable("courses") {

            CoursesScreen(navController)
        }

        composable("profile") {

            ProfileScreen(navController)
        }

        composable(
            route = "detail/{courseId}",

            arguments = listOf(

                navArgument("courseId") {

                    type = NavType.IntType
                }
            )
        ) {

            val courseId =
                it.arguments?.getInt("courseId") ?: 0

            CoursesDetailScreen(
                navController = navController,
                courseId = courseId
            )
        }
    }
}