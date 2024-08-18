package dev.agustacandi.learn.core.utils.ext

import kotlin.math.roundToInt

fun Double.roundedNumber(): String = ((this * 10).roundToInt() / 10.0).toString()