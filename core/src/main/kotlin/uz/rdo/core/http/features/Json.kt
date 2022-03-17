package uz.rdo.core.http.features

import io.ktor.client.HttpClientConfig
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.ContentType
import kotlinx.serialization.json.Json

internal fun HttpClientConfig<*>.json() = install(JsonFeature) {
    val json = Json { prettyPrint = true; ignoreUnknownKeys = true; isLenient = true }
    serializer = KotlinxSerializer(json)
    acceptContentTypes = listOf(ContentType.Application.Json, ContentType.MultiPart.FormData)
}