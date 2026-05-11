// ============================================
// BottomBar.kt
// ============================================

package com.edutechacademy.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.navigation.NavController

@Composable
fun BottomBar(
    navController: NavController,
    currentScreen: String
) {

    NavigationBar {

        NavigationBarItem(

            selected = currentScreen == "home",

            onClick = {

                navController.navigate("home")
            },

            icon = {

                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },

            label = {

                Text("Home")
            }
        )

        NavigationBarItem(

            selected = currentScreen == "courses",

            onClick = {

                navController.navigate("courses")
            },

            icon = {

                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null
                )
            },

            label = {

                Text("Cursos")
            }
        )

        NavigationBarItem(

            selected = currentScreen == "profile",

            onClick = {

                navController.navigate("profile")
            },

            icon = {

                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },

            label = {

                Text("Perfil")
            }
        )
    }
}