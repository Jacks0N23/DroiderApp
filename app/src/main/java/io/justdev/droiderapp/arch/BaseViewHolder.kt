package io.justdev.droiderapp.arch

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.justdev.droiderapp.extentions.inflate

open class BaseViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(item: T) {}
}

abstract class HolderFactory : (ViewGroup, Int) -> BaseViewHolder<ViewTyped> {

    abstract fun createViewHolder(view: View, viewType: Int): BaseViewHolder<*>?

    final override fun invoke(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<ViewTyped> {
        val view: View = viewGroup.inflate(viewType)
        return createViewHolder(view, viewType) as BaseViewHolder<ViewTyped>?
                ?: throw IllegalStateException("unknown viewType")
    }
}