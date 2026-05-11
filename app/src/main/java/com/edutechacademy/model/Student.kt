package com.edutechacademy.model

data class Student(

    val id: Int,
    val name: String,
    val email: String,
    val enrolledCourses: List<Int>,
    val progress: Float
)