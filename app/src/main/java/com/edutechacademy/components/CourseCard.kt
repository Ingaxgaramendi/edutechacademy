// ============================================
// CourseCard.kt
// ============================================

package com.edutechacademy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

import com.edutechacademy.model.Course

@Composable
fun CourseCard(
    course: Course,
    navController: NavController
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable {

                navController.navigate(
                    "detail/${course.id}"
                )
            },

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column {

            Image(
                painter = painterResource(
                    id = course.image
                ),

                contentDescription = course.title,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),

                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = course.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Instructor: ${course.instructor}"
                )

                Text(
                    text = "Nivel: ${course.level}"
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row {

                    Text("🔥 Popular")
                }
            }
        }
    }
}