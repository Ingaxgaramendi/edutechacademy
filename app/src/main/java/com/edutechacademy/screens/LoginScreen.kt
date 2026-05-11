// ============================================
// LoginScreen.kt
// ============================================

package com.edutechacademy.screens

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember {

        mutableStateOf("")
    }

    var password by remember {

        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = "EduTech Academy",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,

            color =
                MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Aprende tecnología de forma moderna 🚀"
        )

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(24.dp)
                ),

            shape = RoundedCornerShape(24.dp),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                OutlinedTextField(
                    value = email,

                    onValueChange = {

                        email = it
                    },

                    label = {

                        Text("Correo")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = password,

                    onValueChange = {

                        password = it
                    },

                    label = {

                        Text("Contraseña")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {

                        if (
                            email.isNotEmpty() &&
                            password.isNotEmpty()
                        ) {

                            navController.navigate("home")
                        }
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),

                    shape = RoundedCornerShape(16.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            MaterialTheme.colorScheme.primary
                    )
                ) {

                    Text(
                        text = "Ingresar",
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                TextButton(
                    onClick = { }
                ) {

                    Text("Crear cuenta")
                }
            }
        }
    }
}