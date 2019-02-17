package io.justdev.droiderapp.di.base

import io.justdev.droiderapp.di.AppComponent

object ApplicationComponentInjector : ComponentInjector<AppComponent> by SynchronizedComponentInjectorImpl()

val appComponent: AppComponent
    get() = ApplicationComponentInjector.component()