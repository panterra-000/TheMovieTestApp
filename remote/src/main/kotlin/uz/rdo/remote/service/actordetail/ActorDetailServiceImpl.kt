package uz.rdo.remote.service.actordetail

import io.ktor.client.*
import uz.rdo.core.NetworkResponse
import uz.rdo.core.util.ktor.getCatching
import uz.rdo.core.util.ktor.getJson
import uz.rdo.remote.data.response.actor.ActorDetailResponse
import uz.rdo.remote.data.response.actor.ActorMovieCreditsResponse
import javax.inject.Inject

class ActorDetailServiceImpl @Inject constructor(private val httpClient: HttpClient) :
    ActorDetailService {

    override suspend fun getActorDetailData(actorId: String): NetworkResponse<ActorDetailResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = createDetailUrl(actorId))
        }
    }

    override suspend fun getActorCreditsData(actorId: String): NetworkResponse<ActorMovieCreditsResponse> {
        return getCatching {
            httpClient.getJson(urlAddress = createCreditsUrl(actorId))
        }
    }

    private companion object {
        fun createDetailUrl(actorId: String): String = "person/$actorId"
        fun createCreditsUrl(actorId: String): String = "person/$actorId/movie_credits"
    }
}