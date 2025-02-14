package com.example.expmdmfebrero.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.expmdmfebrero.app.extensions.loadUrl
import com.example.expmdmfebrero.databinding.ViewMushroomItemBinding

class ViewMushroomItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewMushroomItemBinding.inflate(LayoutInflater.from(context), this, false)

    fun setMushroom(name: String, date: String, description: String, image: String) {
        binding.apply {
            nameMushroom.text = name
            dateMushroom.text = date
            descriptionMushroom.text = description
            imageMushroom.loadUrl(image)
        }
    }
}