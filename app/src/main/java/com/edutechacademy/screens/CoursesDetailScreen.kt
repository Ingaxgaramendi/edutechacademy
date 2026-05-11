// =========================================
// COURSES DETAIL SCREEN
// File: CoursesDetailScreen.kt
// =========================================

package com.edutechacademy.screens

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

import com.edutechacademy.data.CourseData
import androidx.compose.material3.ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesDetailScreen(
    navController: NavController,
    courseId: Int
) {

    val course =
        CourseData.courses.find {
            it.id == courseId
        }

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {

                    Text("Detalle del Curso")
                },

                navigationIcon = {

                    IconButton(
                        onClick = {

                            navController.popBackStack()
                        }
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }

    ) { padding ->

        course?.let {

            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {

                Image(
                    painter = painterResource(
                        id = it.image
                    ),

                    contentDescription = it.title,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),

                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = it.title,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = it.description
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Duración: ${it.duration}"
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "⭐ ${it.rating}"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "👨‍🎓 ${it.students} estudiantes"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "📚 ${it.lessons} lecciones"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "💰 ${it.price}"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "📈 ${it.level}"
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = { },

                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text("Inscribirse")
                    }
                }
            }
        }
    }
}