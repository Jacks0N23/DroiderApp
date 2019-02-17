package io.justdev.droiderapp.api

import com.google.gson.annotations.SerializedName
import io.justdev.droiderapp.arch.ViewTyped

data class Post(@SerializedName("picture_basic")
                val pictureBasic: String? = null,
                @SerializedName("picture_wide")
                val pictureWide: String? = null, val title: String? = null,
                @SerializedName("text")
                val description: String? = null,
                val url: String? = null,
                val date: String? = null,
                @SerializedName("is_important")
                val isImportant: Boolean? = null,
                @SerializedName("is_hot")
                val isHot: Boolean? = null,
                val comments: String? = null,
                val views: Int? = null,
                override val viewType: Int) : ViewTyped
