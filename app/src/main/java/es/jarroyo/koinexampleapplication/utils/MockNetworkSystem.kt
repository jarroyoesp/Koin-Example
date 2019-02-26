package es.jarroyo.koinexampleapplication.utils

class MockNetworkSystem : NetworkSystemInterface {
    val TAG = this::class.java.simpleName

    override fun isNetworkAvailable(): Boolean {
        return mIsNetworkAvailable
    }

    fun setIsNetworkAvailable(isAvailable: Boolean) {
        mIsNetworkAvailable = isAvailable
    }

    companion object {
        var mIsNetworkAvailable: Boolean = false
    }

}