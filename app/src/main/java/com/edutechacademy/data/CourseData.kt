package com.edutechacademy.data

import com.edutechacademy.R
import com.edutechacademy.model.Course

object CourseData {

    val courses: List<Course> = listOf(

        Course(
            id = 1,

            title = "Kotlin desde Cero",

            instructor = "Carlos Ramos",

            level = "Básico",

            category = "Programación",

            duration = "12 horas",

            description =
                "Aprende Kotlin desde cero y desarrolla aplicaciones Android modernas con Jetpack Compose.",

            image = R.drawable.kotlin,

            rating = 4.9,

            students = 5200,

            price = "S/. 89",

            lessons = 32
        ),

        Course(
            id = 2,

            title = "UI/UX Design",

            instructor = "Ana Torres",

            level = "Intermedio",

            category = "Diseño",

            duration = "8 horas",

            description =
                "Aprende diseño moderno para aplicaciones móviles y experiencias visuales atractivas.",

            image = R.drawable.design,

            rating = 4.8,

            students = 3200,

            price = "S/. 79",

            lessons = 24
        ),

        Course(
            id = 3,

            title = "Marketing Digital",

            instructor = "Luis Vega",

            level = "Avanzado",

            category = "Negocios",

            duration = "10 horas",

            description =
                "Domina estrategias modernas de marketing digital y publicidad online.",

            image = R.drawable.marketing,

            rating = 4.7,

            students = 4100,

            price = "S/. 99",

            lessons = 28
        ),

        Course(
            id = 4,

            title = "Jetpack Compose",

            instructor = "María López",

            level = "Intermedio",

            category = "Programación",

            duration = "15 horas",

            description =
                "Construye interfaces modernas y responsivas utilizando Jetpack Compose.",

            image = R.drawable.compose,

            rating = 4.9,

            students = 2900,

            price = "S/. 120",

            lessons = 40
        ),

        Course(
            id = 5,

            title = "Branding Creativo",

            instructor = "Fernando Díaz",

            level = "Básico",

            category = "Diseño",

            duration = "6 horas",

            description =
                "Aprende a construir marcas modernas y visualmente impactantes.",

            image = R.drawable.branding,

            rating = 4.6,

            students = 1800,

            price = "S/. 59",

            lessons = 18
        ),

        Course(
            id = 6,

            title = "Emprendimiento Digital",

            instructor = "Camila Torres",

            level = "Intermedio",

            category = "Negocios",

            duration = "11 horas",

            description =
                "Aprende a crear negocios digitales rentables desde cero.",

            image = R.drawable.business,

            rating = 4.8,

            students = 3500,

            price = "S/. 109",

            lessons = 30
        )
    )
}