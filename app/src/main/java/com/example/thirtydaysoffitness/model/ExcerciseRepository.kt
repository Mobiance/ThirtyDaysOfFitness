package com.example.thirtydaysoffitness.model

import com.example.thirtydaysoffitness.R

object ExcerciseRepository {
    val Excercises = listOf(
        Excercise(
            dayNumber = R.string.day_1,
            title = R.string.excercise1,
            excerciseImage = R.drawable.pushups,
            excerciseDescription = R.string.description1
        ),
        Excercise(
            dayNumber = R.string.day_2,
            title = R.string.pull_ups,
            excerciseImage = R.drawable.pullups,
            excerciseDescription = R.string.description2
        ),
        Excercise(
            dayNumber = R.string.day_3,
            title = R.string.excercise3,
            excerciseImage = R.drawable.plank,
            excerciseDescription = R.string.description3
        )
    )
}