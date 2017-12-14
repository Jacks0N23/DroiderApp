package io.justdev.droiderapp.utils

import android.content.Context
import android.net.wifi.WifiManager

object NetworkUtils {
    fun enableWiFi(c: Context, wifi: Boolean) {
        val wifiConfiguration = c.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiConfiguration.isWifiEnabled = wifi
    }
}