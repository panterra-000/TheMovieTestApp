package uz.rdo.remote.service.moviedetail

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.movie.MovieCreditsResponse
import uz.rdo.remote.data.response.movie.MovieDetailResponse

interface MovieDetailService {
    suspend fun getMovieDetailData(movieId: String): NetworkResponse<MovieDetailResponse>
    suspend fun getMovieCredits(movieId: String): NetworkResponse<MovieCreditsResponse>
}