package uz.rdo.remote.service.moviedetail

import io.ktor.client.*
import uz.rdo.core.NetworkResponse
import uz.rdo.core.util.ktor.getCatching
import uz.rdo.core.util.ktor.getJson
import uz.rdo.remote.data.response.MovieCreditsResponse
import uz.rdo.remote.data.response.detail.MovieDetailResponse
import javax.inject.Inject

class MovieDetailServiceImpl @Inject constructor(private val httpClient: HttpClient) :
    MovieDetailService {

    override suspend fun getMovieDetailData(movieId: String): NetworkResponse<MovieDetailResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = createDetailUrl(movieId))
        }
    }

    override suspend fun getMovieCredits(movieId: String): NetworkResponse<MovieCreditsResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = createCreditsUrl(movieId))
        }
    }

    private companion object {
        fun createDetailUrl(movieId: String): String = "movie/$movieId"
        fun createCreditsUrl(movieId: String): String = "movie/$movieId/credits"
    }

}