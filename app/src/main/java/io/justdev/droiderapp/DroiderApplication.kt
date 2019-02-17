package io.justdev.droiderapp

import android.app.Application
import io.justdev.droiderapp.di.ApplicationContextModule
import io.justdev.droiderapp.di.DaggerAppComponent
import io.justdev.droiderapp.di.base.ApplicationComponentInjector

class DroiderApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder()
                .applicationContextModule(ApplicationContextModule(this))
                .build()
        ApplicationComponentInjector.setComponent(component)
    }
}
