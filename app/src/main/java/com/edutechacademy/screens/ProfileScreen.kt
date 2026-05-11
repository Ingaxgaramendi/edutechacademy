// ============================================
// ProfileScreen.kt
// ============================================

package com.edutechacademy.screens

import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

import com.edutechacademy.components.BottomBar
import com.edutechacademy.data.CourseData
import com.edutechacademy.data.StudentData
import androidx.compose.foundation.background
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {

    val student = StudentData.currentStudent

    val enrolledCourses =

        CourseData.courses.filter {

            student.enrolledCourses.contains(it.id)
        }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "Mi Perfil",
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
                currentScreen = "profile"
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background
                )
                .padding(20.dp)
        ) {

            item {

                Text(
                    text = student.name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(student.email)

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Progreso General",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                LinearProgressIndicator(
                    progress = {

                        student.progress
                    },

                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text =
                        "${(student.progress * 100).toInt()}%"
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "📚 Mis Cursos",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            items(enrolledCourses) { course ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .shadow(
                            10.dp,
                            RoundedCornerShape(20.dp)
                        )
                        .clickable {

                            navController.navigate(
                                "detail/${course.id}"
                            )
                        },

                    shape = RoundedCornerShape(20.dp),

                    elevation =
                        CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = course.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(course.instructor)

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("🔥 En progreso")
                    }
                }
            }
        }
    }
}