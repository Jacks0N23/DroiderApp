package io.justdev.droiderapp.base

import android.content.Context
import android.os.Bundle

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatDelegate

import com.arellomobile.mvp.MvpAppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import io.justdev.droiderapp.utils.NetworkUtils


class DroiderBaseActivity : MvpAppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }

    fun initInternetConnectionDialog(context: Context) {

        AlertDialog.Builder(context).setTitle("Соединение нестабильно или прервано")
                .setMessage("Проверьте своё соединение с интернетом и перезайдите в приложение")
                .setPositiveButton("Перезайти") { dialog, which ->
                    //TODO redo on refresh all data
                    finish()
                    startActivity(intent)
                }.setNegativeButton("Выйти") { _, _ -> finish() }
                .setNeutralButton("Включить Wi-Fi?")
                { _, _ -> NetworkUtils.enableWiFi(context, true) }.create().show()
    }

    companion object {
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
        }
    }
}