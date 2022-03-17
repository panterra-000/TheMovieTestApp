package uz.rdo.core.http

import android.content.Context
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import uz.rdo.core.http.features.defaultRequest
import uz.rdo.core.http.features.json
import uz.rdo.core.http.features.logging

fun httpClient(context: Context) = HttpClient(OkHttp) {
    defaultRequest()
    json()
    logging()
}
