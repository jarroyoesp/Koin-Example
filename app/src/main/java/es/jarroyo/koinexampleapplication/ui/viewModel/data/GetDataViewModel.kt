package es.jarroyo.koinexampleapplication.ui.viewModel.data

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import es.jarroyo.koinexampleapplication.data.Response
import es.jarroyo.koinexampleapplication.data.repository.DataRepository

class GetDataViewModel(val dataRepository: DataRepository)
    : ViewModel() {

    var dataLiveData = MutableLiveData<GetDataState>()

    /**
     * GET DATA
     */
    fun getData() {
        dataLiveData.postValue(LoadingGetDataState())
        dataLiveData.postValue(SuccessGetDataState(Response.Success(dataRepository.getData())))
    }

    override fun onCleared() {
        super.onCleared()
    }
}