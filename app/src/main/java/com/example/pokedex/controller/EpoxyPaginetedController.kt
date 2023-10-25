package com.example.pokedex.controller

abstract class EpoxyPaginatedController<T>(contract: EpoxyPaginatedControllerContract) : BaseEpoxyPaginatedController<T>(contract)  {

    override fun buildModels() {
        renderPaginatedList()
        renderProgressIndicator()
    }

    override fun shouldLoadMore() = !isLastPage && !isLoading
}