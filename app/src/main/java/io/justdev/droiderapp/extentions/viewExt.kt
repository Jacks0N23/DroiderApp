package io.justdev.droiderapp.extentions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun <T> View.inflate(@LayoutRes
                     layout: Int, root: ViewGroup? = null): T {
    return LayoutInflater.from(context).inflate(layout, root ?: this as? ViewGroup, false) as T
}