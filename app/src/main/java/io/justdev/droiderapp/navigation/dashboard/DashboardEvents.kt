package io.justdev.droiderapp.navigation.dashboard

import io.justdev.droiderapp.mvi.EventObservable
import ru.tinkoff.mlca.mvi.BaseEvents

interface DashboardEvents : BaseEvents {
    val loadItemsEvent: EventObservable
}

class DashboardEventsImpl(override val loadItemsEvent: EventObservable, override val unbindEvent: EventObservable) :
        DashboardEvents
