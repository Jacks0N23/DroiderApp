package io.justdev.droiderapp.navigation.dashboard.di

import io.justdev.droiderapp.arch.ViewTyped
import io.justdev.droiderapp.di.base.appComponent
import io.justdev.droiderapp.feed.FeedLoadingInteractor
import io.justdev.droiderapp.mvi.Action
import io.justdev.droiderapp.mvi.ActionMapper
import io.justdev.droiderapp.navigation.dashboard.DashboardEventsBinder
import io.justdev.droiderapp.navigation.dashboard.LoadFeedItemsActionCreator

class DashboardComponent(private val showLoadedFeedItems: ActionMapper<List<ViewTyped>>,
                         private val showError: Action,
                         private val showLoading: Action) {


    fun binder(): DashboardEventsBinder {
        val loadFeedItemsActionCreator = LoadFeedItemsActionCreator(FeedLoadingInteractor(appComponent.droiderApi),
                                                                    showLoadedFeedItems,
                                                                    showLoading,
                                                                    showError)
        return DashboardEventsBinder(loadFeedItemsActionCreator)
    }
}