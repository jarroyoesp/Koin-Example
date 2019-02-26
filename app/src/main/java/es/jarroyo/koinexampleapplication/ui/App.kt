package es.jarroyo.koinexampleapplication.ui

import android.app.Application
import es.jarroyo.koinexampleapplication.di.AppModule
import es.jarroyo.koinexampleapplication.utils.MockNetworkSystem
import org.koin.android.ext.android.startKoin




class App: Application() {

    override fun onCreate() {
        super.onCreate()

        MockNetworkSystem.mIsNetworkAvailable = true

        // Start Koin
        startKoin(this, listOf(AppModule().appModule))
    }
}