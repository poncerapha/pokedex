package com.example.pokedex.ui.viewholders

import com.airbnb.epoxy.EpoxyModelClass
import com.example.pokedex.databinding.HolderProgressIndicatorBinding
import com.example.pokedex.utils.BaseEpoxyModel

@EpoxyModelClass
abstract class ProgressIndicatorHolder: BaseEpoxyModel<HolderProgressIndicatorBinding>(
    HolderProgressIndicatorBinding::inflate
) {
    override fun bind(binding: HolderProgressIndicatorBinding) {}
}