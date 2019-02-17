package io.justdev.droiderapp.navigation

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE_FORCE
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.trello.navi2.Listener
import io.justdev.droiderapp.R
import io.justdev.droiderapp.arch.BaseActivity
import io.justdev.droiderapp.arch.BaseOnCreate
import io.justdev.droiderapp.navigation.dashboard.DashboardFragment
import io.justdev.droiderapp.navigation.podcasts.PodcastsFragment
import kotlinx.android.synthetic.main.activity_main.*

const val BOTTOM_BAR_ITEMS_COUNT = 3

class NavigationActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(): Listener<Bundle> = object : BaseOnCreate(this) {
        override fun call(bundle: Bundle) {
            super.call(bundle)
            navigationView.accentColor = ContextCompat.getColor(this@NavigationActivity, R.color.color_accent_red)
            navigationView.defaultBackgroundColor = ContextCompat.getColor(this@NavigationActivity,
                                                                           R.color.colorForeground_light)
            navigationView.titleState = SHOW_WHEN_ACTIVE_FORCE
            navigationView.setUseElevation(false)
            val navigationAdapter = AHBottomNavigationAdapter(this@NavigationActivity, R.menu.navigation)
            navigationAdapter.setupWithBottomNavigation(navigationView)

            viewPager.adapter = NavigationPagerAdapter(supportFragmentManager,
                                                       listOf(DashboardFragment(),
                                                              PodcastsFragment(),
                                                              SettingsFragment()))
            viewPager.offscreenPageLimit = BOTTOM_BAR_ITEMS_COUNT
            navigationView.setOnTabSelectedListener { position, _ ->
                viewPager.currentItem = position
                true
            }
        }
    }
}