// ============================================
// Theme.kt
// ============================================

package com.edutechacademy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme

import androidx.compose.runtime.Composable

private val AppColors = lightColorScheme(

    primary = PrimaryBlue,

    secondary = DarkBlue,

    background = BackgroundColor,

    surface = CardColor
)

@Composable
fun EdutechacademyTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = AppColors,

        content = content
    )
}