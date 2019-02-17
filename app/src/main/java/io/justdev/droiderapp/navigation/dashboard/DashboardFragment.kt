package io.justdev.droiderapp.navigation.dashboard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.justdev.droiderapp.R
import io.justdev.droiderapp.arch.Adapter
import io.justdev.droiderapp.arch.BaseFragment
import io.justdev.droiderapp.arch.ViewTyped
import io.justdev.droiderapp.navigation.dashboard.di.DashboardComponent
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = Adapter<ViewTyped>(holderFactory = FeedHolderFactory())
        feedList.adapter = adapter
        val component = DashboardComponent(showLoading = { refresher.isRefreshing = true },
                                           showError = Toast.makeText(parentActivity,
                                                                      "Произошла ошибка",
                                                                      Toast.LENGTH_SHORT)::show,
                                           showLoadedFeedItems = {
                                               {
                                                   adapter.setItems(it)
                                                   refresher.isRefreshing = false
                                               }
                                           })
        component.binder()
                .bind(DashboardEventsImpl(bindEvent, unBindEvent))
    }
}