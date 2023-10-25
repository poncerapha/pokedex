package com.example.pokedex.controller

import com.airbnb.epoxy.EpoxyController
import com.example.pokedex.interfaces.EpoxyPaginatedControllerContract
import com.example.pokedex.ui.viewholders.progressIndicatorHolder

abstract class BaseEpoxyPaginatedController<T>(
    private val _contract: EpoxyPaginatedControllerContract
) : EpoxyController() {
    private val contract
        get() = _contract
    private var items = mutableListOf<T>()
    protected var isLastPage: Boolean = false
    protected var isLoading = false
    private var hasRequestError = false

    protected fun renderPaginatedList() {
        items.forEachIndexed { index, item ->
            renderPaginatedHolder(item, index)
        }
    }

    protected fun renderProgressIndicator() {
        if (hasRequestError) {
            hasRequestError = false
        } else renderProgressHolder()
    }

    private fun renderProgressHolder() {
        if (!isLastPage) {
            progressIndicatorHolder {
                id("loading_indicator")
                onBind { _, view, _ ->
                    if (this@BaseEpoxyPaginatedController.shouldLoadMore()) {
                        this@BaseEpoxyPaginatedController.contract.loadMore()
                    }
                }
            }
        }
    }

    abstract fun shouldLoadMore(): Boolean

    abstract fun renderPaginatedHolder(item: T, index: Int)

    fun setIsLastPage(isLastPage: Boolean) {
        this.isLastPage = isLastPage
        requestModelBuild()
    }

    fun updatePaginatedList(list: List<T>) {
        items = list.toMutableList()
        requestModelBuild()
    }

    fun setError() {
        hasRequestError = true
        requestModelBuild()
    }

    fun setLoading() {
        isLoading = true
        requestModelBuild()
    }

    fun getPaginatedList() = items
}