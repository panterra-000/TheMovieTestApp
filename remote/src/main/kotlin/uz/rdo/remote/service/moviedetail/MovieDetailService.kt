package uz.rdo.remote.service.moviedetail

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.MovieCreditsResponse
import uz.rdo.remote.data.response.detail.MovieDetailResponse

interface MovieDetailService {
    suspend fun getMovieDetailData(movieId: String): NetworkResponse<MovieDetailResponse>
    suspend fun getMovieCredits(movieId: String): NetworkResponse<MovieCreditsResponse>
}