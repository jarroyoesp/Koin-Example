package es.jarroyo.koinexampleapplication.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkSystem(val context: Context) : NetworkSystemInterface {

    private val TAG = this::class.java.simpleName

    override fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
}