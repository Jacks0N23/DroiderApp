package io.justdev.droiderapp.arch

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class Adapter<T : ViewTyped>(private val items: MutableList<ViewTyped> = mutableListOf(),
                                  private val holderFactory: HolderFactory) :
        RecyclerView.Adapter<BaseViewHolder<ViewTyped>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewTyped> =
            holderFactory(parent, viewType)

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: BaseViewHolder<ViewTyped>, position: Int) = holder.bind(items[position])

    fun setItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): T = items[position] as T
    fun getItems(): MutableList<T> = items as MutableList<T>

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }
}