package io.justdev.droiderapp.arch

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.analytics.FirebaseAnalytics
import com.trello.navi2.Event
import com.trello.navi2.Listener
import com.trello.navi2.component.support.NaviAppCompatActivity
import io.justdev.droiderapp.extentions.enableWiFi
import io.justdev.droiderapp.extentions.observe

abstract class BaseActivity(@LayoutRes
                            open val layout: Int) : NaviAppCompatActivity() {

    var firebaseAnalytics: FirebaseAnalytics? = null
    val unBindEvent = observe(Event.DESTROY)
    val bindEvent = observe(Event.POST_CREATE)

    init {
        addListener(Event.CREATE, onCreate())
    }

    protected abstract fun onCreate(): Listener<Bundle>

    fun showInternetConnectionDialog(context: Context) {
        AlertDialog.Builder(context)
                .setTitle("Соединение нестабильно или прервано")
                .setMessage("Проверьте своё соединение с интернетом и перезайдите в приложение")
                .setPositiveButton("Перезайти") { dialog, which ->
                    //TODO redo on refresh all data
                    finish()
                    startActivity(intent)
                }
                .setNegativeButton("Выйти") { _, _ -> finish() }
                .setNeutralButton("Включить Wi-Fi?") { _, _ -> context.enableWiFi() }
                .create()
                .show()
    }

    companion object {
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
        }
    }
}