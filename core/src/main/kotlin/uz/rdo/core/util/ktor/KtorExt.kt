package uz.rdo.core.util.ktor

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.takeFrom

suspend inline fun <reified T> HttpClient.postJson(
    urlAddress: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = post {
    contentType(ContentType.Application.Json)
    url.takeFrom(urlAddress)
    body
    block()
}

suspend inline fun <reified T> HttpClient.putJson(
    urlAddress: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = put {
    contentType(ContentType.Application.Json)
    url.takeFrom(urlAddress)
    block()
}

suspend inline fun <reified T> HttpClient.getJson(
    urlAddress: String,
    block: HttpRequestBuilder.() -> Unit = {}
): T = get {
    contentType(ContentType.Application.Json)
    url.takeFrom(urlAddress)
    block()
}

suspend inline fun <reified T> HttpClient.submitFormDefault(
    urlAddress: String,
    contentType: ContentType = ContentType.MultiPart.FormData,
    block: HttpRequestBuilder.() -> Unit = {}
): T = submitForm {
    contentType(contentType)
    url.takeFrom(urlAddress)
    block()
}

