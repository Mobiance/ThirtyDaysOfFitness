package com.example.thirtydaysoffitness.model

import com.example.thirtydaysoffitness.R

object excerciseRepository {
    val excercises = listOf(
        excercise(
            dayNumber = R.string.day_1,
            title = R.string.excercise1,
            excerciseImage = R.drawable.pushups,
            excerciseDescription = R.string.description1
        ),
        excercise(
            dayNumber = R.string.day_2,
            title = R.string.pull_ups,
            excerciseImage = R.drawable.pullups,
            excerciseDescription = R.string.description2
        )
    )
}