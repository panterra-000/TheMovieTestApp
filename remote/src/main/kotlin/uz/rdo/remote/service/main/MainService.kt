package uz.rdo.remote.service.main

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.movie.MoviesResponse

interface MainService {
    suspend fun getPopularMovies(page: Int): NetworkResponse<MoviesResponse>
    suspend fun getTopRatedMovies(page: Int): NetworkResponse<MoviesResponse>
    suspend fun getUpcomingMovies(page: Int): NetworkResponse<MoviesResponse>

}