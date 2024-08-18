package dev.agustacandi.learn.core.utils

import android.content.Context
import android.widget.Toast

object Helper {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}