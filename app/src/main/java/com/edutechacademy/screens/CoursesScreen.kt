// ============================================
// COURSES SCREEN FINAL
// ============================================

package com.edutechacademy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController

import com.edutechacademy.components.BottomBar
import com.edutechacademy.components.CourseCard
import com.edutechacademy.data.CourseData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavController) {

    var selectedCategory by remember {

        mutableStateOf("Todos")
    }

    var search by remember {

        mutableStateOf("")
    }

    val filteredCourses =

        CourseData.courses.filter {

            (
                    selectedCategory == "Todos"
                            ||
                            it.category == selectedCategory
                    )

                    &&

                    (
                            it.title.contains(
                                search,
                                ignoreCase = true
                            )
                            )
        }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "Explorar Cursos",
                        color =
                            MaterialTheme.colorScheme.onPrimary
                    )
                },

                colors =
                    TopAppBarDefaults.topAppBarColors(

                        containerColor =
                            MaterialTheme.colorScheme.primary
                    )
            )
        },

        bottomBar = {

            BottomBar(
                navController = navController,
                currentScreen = "courses"
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background
                )
        ) {

            // =================================
            // BUSCADOR 😎
            // =================================

            OutlinedTextField(
                value = search,

                onValueChange = {

                    search = it
                },

                label = {

                    Text("Buscar cursos")
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                shape = RoundedCornerShape(18.dp)
            )

            // =================================
            // CATEGORÍAS 😎
            // =================================

            Row(
                modifier = Modifier
                    .horizontalScroll(
                        rememberScrollState()
                    )
                    .padding(horizontal = 16.dp),

                horizontalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {

                listOf(
                    "Todos",
                    "Programación",
                    "Diseño",
                    "Negocios"
                ).forEach { category ->

                    Card(
                        onClick = {

                            selectedCategory = category
                        },

                        shape = RoundedCornerShape(16.dp),

                        elevation =
                            CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            )
                    ) {

                        Text(
                            text = category,

                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 10.dp
                            ),

                            maxLines = 1,

                            fontWeight =
                                if (
                                    selectedCategory == category
                                )

                                    FontWeight.Bold

                                else

                                    FontWeight.Normal
                        )
                    }
                }
            }

            // =================================
            // LISTA DE CURSOS 😎
            // =================================

            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {

                items(filteredCourses) { course ->

                    CourseCard(
                        course = course,
                        navController = navController
                    )
                }
            }
        }
    }
}