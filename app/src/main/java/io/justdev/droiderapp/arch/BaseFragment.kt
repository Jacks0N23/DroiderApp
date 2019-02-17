package io.justdev.droiderapp.arch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.trello.navi2.Event
import com.trello.navi2.component.support.NaviFragment
import io.justdev.droiderapp.extentions.observe
import io.reactivex.Observable

abstract class BaseFragment(@LayoutRes
                            val layout: Int) : NaviFragment() {

    val unBindEvent: Observable<*> = observe(Event.DESTROY_VIEW)
    val bindEvent: Observable<*> = Observable.just(true)
    val parentActivity: AppCompatActivity by lazy(LazyThreadSafetyMode.NONE) {
        activity as? AppCompatActivity ?: throw NullPointerException("parentActivity is null")
    }
    val intent: Intent
        get() = parentActivity.intent
    val args: Bundle
        get() = arguments ?: throw NullPointerException("arguments is null")

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layout, container, false)
    }
}