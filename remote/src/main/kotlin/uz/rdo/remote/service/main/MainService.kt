package uz.rdo.remote.service.main

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.MoviesResponse

interface MainService {
    suspend fun getPopularMovies(page: Int): NetworkResponse<MoviesResponse>

}