package es.jarroyo.koinexampleapplication.ui.viewModel.data

import es.jarroyo.koinexampleapplication.data.Response


sealed class GetDataState {
    abstract val response: Response<String>?
}
data class SuccessGetDataState(override val response: Response<String>) : GetDataState()
data class LoadingGetDataState(override val response: Response<String>? = null) : GetDataState()
data class ErrorGetDataState(override val response: Response<String>) : GetDataState()