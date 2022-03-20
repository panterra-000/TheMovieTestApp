package uz.rdo.remote.service.actordetail

import uz.rdo.core.NetworkResponse
import uz.rdo.remote.data.response.actor.ActorDetailResponse

interface ActorDetailService {
    suspend fun getActorDetailData(movieId: String): NetworkResponse<ActorDetailResponse>

}