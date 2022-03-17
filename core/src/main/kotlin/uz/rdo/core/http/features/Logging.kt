package uz.rdo.core.http.features

import android.util.Log
import io.ktor.client.HttpClientConfig
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging

private const val HTTP_KTOR_TAG = "Http Client"

internal fun HttpClientConfig<*>.logging() = install(Logging) {
    level = LogLevel.ALL
    logger = object : Logger {
        override fun log(message: String) {
            Log.w(HTTP_KTOR_TAG, message)
        }
    }
}

