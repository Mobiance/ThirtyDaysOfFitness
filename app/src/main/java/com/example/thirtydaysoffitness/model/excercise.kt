package com.example.thirtydaysoffitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class excercise(
    @StringRes val dayNumber: Int,
    @StringRes val title: Int,
    @DrawableRes val excerciseImage: Int,
    @StringRes val excerciseDescription: Int
)
