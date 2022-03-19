package uz.rdo.remote.service.actordetail

import io.ktor.client.*
import javax.inject.Inject

class ActorDetailServiceImpl @Inject constructor(private val httpClient: HttpClient) : ActorDetailService {
}