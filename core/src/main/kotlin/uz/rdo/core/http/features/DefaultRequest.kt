package uz.rdo.core.http.features

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import uz.rdo.core.BuildConfig

private const val HEADER_API_KEY = "api_key"
private const val HEADER_API_KEY_VALUE = "d07b7816061513f52e0c20ab6d96fa00"

internal fun HttpClientConfig<*>.defaultRequest() = install(DefaultRequest) {
    url.protocol = URLProtocol.HTTPS
    url.withBaseUrl()
//    header(HEADER_API_KEY, HEADER_API_KEY_VALUE)
}


private fun URLBuilder.withBaseUrl(url: String = BuildConfig.BASE_URL): URLBuilder {
    val baseUrl = Url(url)
    val urlBuilder = URLBuilder(baseUrl).apply { encodedPath += this@withBaseUrl.encodedPath }
    return takeFrom(urlBuilder)
}