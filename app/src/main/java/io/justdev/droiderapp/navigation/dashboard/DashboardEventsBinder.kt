package io.justdev.droiderapp.navigation.dashboard

import io.justdev.droiderapp.mvi.Action
import io.justdev.droiderapp.mvi.BaseEventsBinder
import io.reactivex.Observable

class DashboardEventsBinder(private val loadFeedItemsActionCreator: LoadFeedItemsActionCreator) :
        BaseEventsBinder<DashboardEvents>() {

    override fun bindInternal(events: DashboardEvents): Observable<Action> {
        return loadFeedItemsActionCreator(events.loadItemsEvent)
    }
}