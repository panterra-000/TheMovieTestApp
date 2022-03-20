package uz.rdo.remote.service.main

import io.ktor.client.*
import io.ktor.client.request.*
import uz.rdo.core.NetworkResponse
import uz.rdo.core.util.ktor.getCatching
import uz.rdo.core.util.ktor.getJson
import uz.rdo.remote.data.response.movie.MoviesResponse
import javax.inject.Inject

class MainServiceImpl @Inject constructor(private val httpClient: HttpClient) : MainService {

    override suspend fun getPopularMovies(page: Int): NetworkResponse<MoviesResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = POPULAR)
            {
                parameter("page", page)
            }
        }
    }

    override suspend fun getTopRatedMovies(page: Int): NetworkResponse<MoviesResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = TOP_RATED)
            {
                parameter("page", page)
            }
        }
    }

    override suspend fun getUpcomingMovies(page: Int): NetworkResponse<MoviesResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = UPCOMING)
            {
                parameter("page", page)
            }
        }
    }

    private companion object {
        const val POPULAR: String = "movie/popular"
        const val TOP_RATED: String = "movie/top_rated"
        const val UPCOMING: String = "movie/upcoming"
    }

}