package com.example.expmdmfebrero.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.expmdmfebrero.R

fun ImageView.loadUrl(url: String) {
    Glide
        .with(this)
        .load(url)
        .placeholder(R.drawable.ic_launcher_foreground)
}