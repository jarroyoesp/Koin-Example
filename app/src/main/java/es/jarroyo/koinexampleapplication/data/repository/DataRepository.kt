package es.jarroyo.koinexampleapplication.data.repository

import es.jarroyo.koinexampleapplication.utils.NetworkSystemInterface

class DataRepository(val networkSystem: NetworkSystemInterface) {

    fun getData(): String {
        if (networkSystem.isNetworkAvailable()) {
            return "Data"
        } else {
            return "No Internet"
        }
    }

}