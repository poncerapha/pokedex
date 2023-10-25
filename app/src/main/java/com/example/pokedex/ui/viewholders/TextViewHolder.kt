package com.example.pokedex.ui.viewholders

import androidx.core.view.isVisible
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.pokedex.databinding.HolderTextViewBinding
import com.example.pokedex.utils.BaseEpoxyModel

@EpoxyModelClass
abstract class TextViewHolder: BaseEpoxyModel<HolderTextViewBinding>(
    HolderTextViewBinding::inflate
) {
    @EpoxyAttribute
    lateinit var text: String

    @EpoxyAttribute
    var shouldShowDivider: Boolean = false

    override fun bind(binding: HolderTextViewBinding) {
        with(binding) {
            itemText.text = text
            divider.isVisible = shouldShowDivider
        }
    }
}