package com.example.pokedex.controller

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.example.pokedex.ui.viewholders.progressIndicatorHolder

abstract class BaseEpoxyPaginatedController<T>(
    private var _contract: EpoxyPaginatedControllerContract? = null
) : EpoxyController() {
    private var items = mutableListOf<T>()
    var isFirstLoadingBind = true
    var isSpanCountChange = false
    protected var isLastPage: Boolean = false
    var isLoading = false
    protected val contract
        get() = _contract!!

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
                    this@BaseEpoxyPaginatedController.isSpanCountChange = false
                    this@BaseEpoxyPaginatedController.isFirstLoadingBind = false
                    this@BaseEpoxyPaginatedController.onBindProgressHolder(view)
                }
            }
        }
    }

    open fun onBindProgressHolder(binding: View) {}

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

    fun removeError() {
        hasRequestError = false
        requestModelBuild()
    }

    fun getPaginatedList() = items

    interface EpoxyPaginatedControllerContract {
        fun loadMore()
        fun onPaginatedListRetryButtonClick() {}
    }
}