package io.justdev.droiderapp.navigation.dashboard

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import io.justdev.droiderapp.R
import io.justdev.droiderapp.api.Post
import io.justdev.droiderapp.arch.BaseViewHolder
import io.justdev.droiderapp.arch.HolderFactory

class FeedHolderFactory : HolderFactory() {
    override fun createViewHolder(view: View, viewType: Int): BaseViewHolder<*>? {
        return when (viewType) {
            R.layout.item_article_card -> ArticleCardViewHolder(view)
            else -> throw NotImplementedError()
        }
    }
}

class ArticleCardViewHolder(view: View) : BaseViewHolder<Post>(view) {

    private val image: ImageView = view.findViewById(R.id.image)
    private val title: TextView = view.findViewById(R.id.title)
    private val description: TextView = view.findViewById(R.id.description)

    override fun bind(item: Post) {
        title.text = item.title
        description.text = item.description
        Picasso.get()
                .load(item.pictureWide)
                .into(image)
    }
}