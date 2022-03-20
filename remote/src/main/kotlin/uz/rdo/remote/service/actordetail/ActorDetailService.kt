package uz.rdo.remote.service.actordetail

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.actor.ActorDetailResponse
import uz.rdo.remote.data.response.actor.ActorMovieCreditsResponse

interface ActorDetailService {
    suspend fun getActorDetailData(movieId: String): NetworkResponse<ActorDetailResponse>
    suspend fun getActorCreditsData(movieId: String): NetworkResponse<ActorMovieCreditsResponse>
}