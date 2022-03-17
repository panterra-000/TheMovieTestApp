package uz.rdo.core.util.ktor

import uz.rdo.core.BaseResponse

suspend fun <T> getCatching(request: suspend () -> T): BaseResponse<T> {
    runCatching {
        val response: T = request.invoke()
        response
    }.onSuccess {
        return BaseResponse.Success(it)
    }.onFailure {
            return BaseResponse.Error(message = it.message)
    }
    return BaseResponse.Empty
}
