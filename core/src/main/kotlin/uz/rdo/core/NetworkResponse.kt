package uz.rdo.core

sealed class NetworkResponse<out T> {
    object Empty : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
    data class Success<out T>(val result: T) : NetworkResponse<T>()
    data class Error(val message: String?) : NetworkResponse<Nothing>()
}
