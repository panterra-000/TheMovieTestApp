package uz.rdo.remote.service.main

import io.ktor.client.*
import io.ktor.client.request.*
import uz.rdo.core.BaseResponse
import uz.rdo.core.util.ktor.getCatching
import uz.rdo.core.util.ktor.getJson
import uz.rdo.remote.data.response.MoviesResponse
import javax.inject.Inject

class MainServiceImpl @Inject constructor(private val httpClient: HttpClient) : MainService {

    override suspend fun getPopularMovies(): BaseResponse<MoviesResponse> {
      return getCatching {
        httpClient.getJson(urlAddress = POPULAR)
        {
            parameter("api_key","d07b7816061513f52e0c20ab6d96fa00")
        }
      }
    }


    private companion object {
        const val POPULAR: String = "movie/popular"
        const val TOP_RATED: String = "movie/top_rated"
        const val UPCOMING: String = "movie/upcoming"
    }

}