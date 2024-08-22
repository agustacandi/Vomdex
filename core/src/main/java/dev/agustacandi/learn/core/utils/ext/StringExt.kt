package dev.agustacandi.learn.core.utils.ext

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Locale

fun String.getYear(): String {
    val dateString = this.ifEmpty { LocalDateTime.now().toString() }
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = format.parse(dateString)
    val year = SimpleDateFormat("yyyy", Locale.getDefault()).format(date!!)
    return year
}