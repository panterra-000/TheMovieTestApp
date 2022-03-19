package uz.rdo.core.util.ktor

import uz.rdo.core.NetworkResponse

suspend fun <T> getCatching(request: suspend () -> T): NetworkResponse<T> {
    runCatching {
        val response: T = request.invoke()
        response
    }.onSuccess {
        return NetworkResponse.Success(it)
    }.onFailure {
            return NetworkResponse.Error(message = it.message)
    }
    return NetworkResponse.Empty
}
