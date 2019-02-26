package es.jarroyo.koinexampleapplication.di

import es.jarroyo.koinexampleapplication.data.repository.DataRepository
import es.jarroyo.koinexampleapplication.ui.viewModel.data.GetDataViewModel
import es.jarroyo.koinexampleapplication.utils.NetworkSystem
import es.jarroyo.koinexampleapplication.utils.NetworkSystemInterface
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class AppModule {

    val appModule : Module = module{

        // NetworkSystem
        single<NetworkSystemInterface> { NetworkSystem(get()) }

        // DataRepository
        factory { DataRepository(get()) }


        // VIEW MODEL
        viewModel{ GetDataViewModel(get()) }
    }
}