package com.example.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Lorem ipsum dolor sit amet dummies clsla",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor",
        R.drawable.onboarding1
    ),
    Page(
        "Lorem ipsum dolor sit amet dummies clsla",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor 2",
        R.drawable.onboarding2
    ),
    Page(
        "Lorem ipsum dolor sit amet dummies clsla",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor 3",
        R.drawable.onboarding3
    ),

    )