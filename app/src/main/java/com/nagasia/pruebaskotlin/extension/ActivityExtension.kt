package com.nagasia.pruebaskotlin.extension

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes


fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
}

fun <T : View> Activity.bindViews(@IdRes resList: IntArray): List<Lazy<T>> {
    return resList.map { bindView<T>(it) }.toList()
}

fun Activity.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}