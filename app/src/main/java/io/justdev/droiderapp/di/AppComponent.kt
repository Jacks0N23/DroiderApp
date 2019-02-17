package io.justdev.droiderapp.di

import android.content.Context
import dagger.Component
import io.justdev.droiderapp.api.DroiderApi
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationContextModule::class, NetworkModule::class])
interface AppComponent {

    @ApplicationContext
    fun applicationContext(): Context

    val droiderApi: DroiderApi
}