package com.groundzero.gloriapatri.utils

import androidx.navigation.NavOptions

val navAnimOption = fun(animIn: Int, animOut: Int): NavOptions =
    NavOptions.Builder()
        .setEnterAnim(animIn)
        .setExitAnim(animOut)
        .setPopEnterAnim(animIn)
        .setPopExitAnim(animOut)
        .build()