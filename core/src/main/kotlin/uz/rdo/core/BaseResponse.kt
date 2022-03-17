package uz.rdo.core

sealed class BaseResponse<out T> {
    object Empty : BaseResponse<Nothing>()
    object Loading : BaseResponse<Nothing>()
    data class Success<out T>(val result: T) : BaseResponse<T>()
    data class Error(val message: String?) : BaseResponse<Nothing>()
}
