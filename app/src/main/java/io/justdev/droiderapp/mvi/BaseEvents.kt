package ru.tinkoff.mlca.mvi

import io.justdev.droiderapp.mvi.EventObservable

interface BaseEvents {
    val unbindEvent: EventObservable
}