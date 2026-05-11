package com.edutechacademy

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.edutechacademy.navigation.AppNavigation
import com.edutechacademy.ui.theme.EdutechacademyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            EdutechacademyTheme {

                AppNavigation()
            }
        }
    }
}