package com.example.pokedex.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.airbnb.epoxy.EpoxyModel

@Suppress("UNCHECKED_CAST")
abstract class BindingEpoxyModel<T : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T
) : EpoxyModel<View>() {

    override fun getDefaultLayout() = 0

    override fun buildView(parent: ViewGroup): View {
        val binding = bindingInflater(LayoutInflater.from(parent.context), parent, false)
        return binding.root.also { it.tag = binding }
    }

    override fun bind(view: View) {
        super.bind(view)
        bind(view.tag as T)
    }

    override fun bind(view: View, previouslyBoundModel: EpoxyModel<*>) {
        bind(view.tag as T, previouslyBoundModel)
    }

    override fun unbind(view: View) {
        unbind(view.tag as T)
        super.unbind(view)
    }

    abstract fun bind(binding: T)

    open fun bind(binding: T, previouslyBoundModel: EpoxyModel<*>) {
        super.bind(binding.root, previouslyBoundModel)
    }

    open fun unbind(binding: T) = Unit
}