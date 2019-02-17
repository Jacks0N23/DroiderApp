package io.justdev.droiderapp.extentions

import android.content.Context
import android.net.wifi.WifiManager

fun Context.enableWiFi() {
    val wifiConfiguration = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    wifiConfiguration.isWifiEnabled = true
}