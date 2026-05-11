// ============================================
// Course.kt UPDATED
// ============================================

package com.edutechacademy.model

data class Course(

    val id: Int,

    val title: String,

    val instructor: String,

    val level: String,

    val category: String,

    val duration: String,

    val description: String,

    val image: Int,

    // NUEVOS CAMPOS 😎

    val rating: Double,

    val students: Int,

    val price: String,

    val lessons: Int
)