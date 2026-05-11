// ============================================
// HomeScreen.kt FINAL
// ============================================

package com.edutechacademy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow

import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

import com.edutechacademy.R
import com.edutechacademy.components.BottomBar
import com.edutechacademy.data.CourseData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "EduTech Academy",
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
                currentScreen = "home"
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
                .padding(20.dp)
        ) {

            // ==========================================
            // SALUDO
            // ==========================================

            Text(
                text = "Hola Anderson 👋",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Continúa aprendiendo hoy 🚀"
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ==========================================
            // BANNER PRINCIPAL 😎
            // ==========================================
// ==========================================
// BANNER MEJORADO 😎🔥
// REEMPLAZA SOLO EL CARD DEL BANNER
// ==========================================

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        14.dp,
                        RoundedCornerShape(24.dp)
                    ),

                shape = RoundedCornerShape(24.dp),

                elevation =
                    CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
            ) {

                Box {

                    // ======================================
                    // IMAGEN
                    // ======================================

                    Image(
                        painter = painterResource(
                            id = R.drawable.banner
                        ),

                        contentDescription = null,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp),

                        contentScale = ContentScale.Crop
                    )

                    // ======================================
                    // CAPA OSCURA 😎
                    // ======================================

                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                MaterialTheme.colorScheme.scrim.copy(
                                    alpha = 0.45f
                                )
                            )
                    )

                    // ======================================
                    // TEXTO
                    // ======================================

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(22.dp)
                    ) {

                        Text(
                            text = "🚀 Aprende habilidades del futuro",

                            color =
                                MaterialTheme.colorScheme.onPrimary,

                            fontSize = 28.sp,

                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "Explora cursos de programación, diseño y negocios digitales.",

                            color =
                                MaterialTheme.colorScheme.onPrimary,

                            fontSize = 15.sp,

                            lineHeight = 22.sp
                        )

                        Spacer(
                            modifier =
                                Modifier.height(18.dp)
                        )

                        // ==================================
                        // BOTÓN 😎🔥
                        // ==================================

                        Button(

                            onClick = {

                                navController.navigate(
                                    "courses"
                                )
                            },

                            shape = RoundedCornerShape(16.dp)

                        ) {

                            Text(
                                text = "Explorar Cursos"
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // ==========================================
            // CURSOS POPULARES
            // ==========================================

            Text(
                text = "🔥 Cursos Populares",

                fontSize = 24.sp,

                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            LazyRow(
                horizontalArrangement =
                    Arrangement.spacedBy(16.dp)
            ) {

                items(CourseData.courses) { course ->

                    Card(
                        modifier = Modifier
                            .width(250.dp)
                            .shadow(
                                12.dp,
                                RoundedCornerShape(22.dp)
                            )
                            .clickable {

                                navController.navigate(
                                    "detail/${course.id}"
                                )
                            },

                        shape = RoundedCornerShape(22.dp),

                        elevation =
                            CardDefaults.cardElevation(
                                defaultElevation = 8.dp
                            )
                    ) {

                        Column {

                            // ==========================
                            // IMAGEN DEL CURSO
                            // ==========================

                            Image(
                                painter = painterResource(
                                    id = course.image
                                ),

                                contentDescription = null,

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(140.dp),

                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier =
                                    Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = course.title,

                                    fontWeight =
                                        FontWeight.Bold,

                                    fontSize = 18.sp,

                                    maxLines = 1
                                )

                                Spacer(
                                    modifier =
                                        Modifier.height(6.dp)
                                )

                                Text(
                                    text =
                                        "👨‍🏫 ${course.instructor}"
                                )

                                Spacer(
                                    modifier =
                                        Modifier.height(6.dp)
                                )

                                Text(
                                    text =
                                        "⭐ ${course.rating}"
                                )

                                Spacer(
                                    modifier =
                                        Modifier.height(6.dp)
                                )

                                Text(
                                    text =
                                        "📚 ${course.level}"
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // ==========================================
            // CATEGORÍAS
            // ==========================================

            Text(
                text = "📚 Categorías",

                fontSize = 24.sp,

                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .horizontalScroll(
                        rememberScrollState()
                    ),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                listOf(
                    "Programación",
                    "Diseño",
                    "Negocios"
                ).forEach { category ->

                    Card(
                        modifier = Modifier.clickable {

                            navController.navigate(
                                "courses"
                            )
                        },

                        shape = RoundedCornerShape(18.dp),

                        elevation =
                            CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            )
                    ) {

                        Text(
                            text = category,

                            modifier = Modifier.padding(
                                horizontal = 20.dp,
                                vertical = 12.dp
                            ),

                            fontWeight = FontWeight.Bold,

                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}