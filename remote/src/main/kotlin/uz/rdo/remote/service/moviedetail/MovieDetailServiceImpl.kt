package uz.rdo.remote.service.moviedetail

import io.ktor.client.*
import uz.rdo.core.NetworkResponse
import uz.rdo.core.util.ktor.getCatching
import uz.rdo.core.util.ktor.getJson
import uz.rdo.remote.data.response.detail.MovieDetailResponse
import javax.inject.Inject

class MovieDetailServiceImpl @Inject constructor(private val httpClient: HttpClient) :
    MovieDetailService {

    override suspend fun getMovieDetailData(movieId: String): NetworkResponse<MovieDetailResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = "$MOVIE_DETAIL/$movieId")
        }
    }

    private companion object {
        const val MOVIE_DETAIL: String = "movie"
    }

}