package es.jarroyo.koinexampleapplication.di

import es.jarroyo.koinexampleapplication.data.repository.DataRepository
import es.jarroyo.koinexampleapplication.utils.MockNetworkSystem
import es.jarroyo.koinexampleapplication.utils.NetworkSystemInterface
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class AppModule {

    val appModule : Module = module{

        // NetworkSystem
        single<NetworkSystemInterface> { MockNetworkSystem() }

        // DataRepository
        factory { DataRepository(get()) }
    }
}