package com.edutechacademy.data

import com.edutechacademy.model.Student

object StudentData {

    val currentStudent = Student(

        id = 1,

        name = "Anderson Rivera",

        email = "anderson@gmail.com",

        enrolledCourses = listOf(
            1,
            2,
            4
        ),

        progress = 0.7f
    )
}