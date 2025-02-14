package com.example.expmdmfebrero.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.expmdmfebrero.databinding.ViewCollectionItemBinding

class ViewCollectionItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding =
        ViewCollectionItemBinding.inflate(LayoutInflater.from(context), this, false)

    fun setMushroom(name: String) {
        binding.apply {
            nameCollection.text = name
        }
    }
}