package com.example.pokedex.controller

import com.example.pokedex.interfaces.EpoxyPaginatedControllerContract

abstract class EpoxyPaginatedController<T>(
    contract: EpoxyPaginatedControllerContract
): BaseEpoxyPaginatedController<T>(contract)  {

    override fun buildModels() {
        renderPaginatedList()
        renderProgressIndicator()
    }

    override fun shouldLoadMore() = !isLastPage && !isLoading
}