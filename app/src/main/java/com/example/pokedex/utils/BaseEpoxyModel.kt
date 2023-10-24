package com.example.pokedex.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.viewbinding.ViewBinding
import com.airbnb.epoxy.EpoxyAttribute

abstract class BaseEpoxyModel<T : ViewBinding>(
    bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T
) : BindingEpoxyModel<T>(bindingInflater) {

    @ColorInt
    @EpoxyAttribute
    var backgroundColor: Int? = null

    @ColorRes
    @EpoxyAttribute
    var backgroundColorRes: Int? = null

    override fun bind(view: View) {
        setupBackground(view)
        super.bind(view)
    }

    private fun setupBackground(view: View) {
        with(view) {
            backgroundColor?.let(::setBackgroundColor)
                ?: backgroundColorRes?.let(::setBackgroundResource)
        }
    }
}