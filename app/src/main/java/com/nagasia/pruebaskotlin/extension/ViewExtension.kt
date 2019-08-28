package com.nagasia.pruebaskotlin.extension

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

fun View.isVisible() : Boolean {
    return this.visibility == View.VISIBLE
}

fun TextView.setTextAndHideViewIfIsNeeded(text: String) {
    if (!TextUtils.isEmpty(text)) {
        this.text = text
        this.visibility = View.VISIBLE
    } else {
        this.text = ""
        this.visibility = View.GONE
    }
}

fun ImageView.loadUrl(url: String) {
    Picasso.with(this.context).load(url).into(this)
}

fun RecyclerView.setUp(layoutManager: RecyclerView.LayoutManager,
                       adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    this.layoutManager = layoutManager
    this.adapter = adapter
}

fun View.hide(){
    when(this.visibility){
        View.GONE -> this.visibility=View.VISIBLE
        View.VISIBLE -> this.visibility=View.GONE
    }
}
