package io.justdev.droiderapp.arch

import android.os.Bundle
import androidx.annotation.CallSuper
import com.google.firebase.analytics.FirebaseAnalytics
import com.trello.navi2.Listener

abstract class BaseOnCreate(private val activity: BaseActivity) : Listener<Bundle> {
    @CallSuper
    override fun call(bundle: Bundle) {
        activity.setContentView(activity.layout)
        activity.firebaseAnalytics = FirebaseAnalytics.getInstance(activity)
    }
}