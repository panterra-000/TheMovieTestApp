package uz.rdo.remote.service.moviedetail

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.detail.MovieDetailResponse

interface MovieDetailService {
    suspend fun getMovieDetailData(movieId: Long): NetworkResponse<MovieDetailResponse>
}