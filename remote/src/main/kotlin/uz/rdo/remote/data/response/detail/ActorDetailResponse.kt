package uz.rdo.remote.data.response.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorDetailResponse(

    @SerialName("also_known_as")
    val alsoKnownAs: List<String?>? = null,

    @SerialName("birthday")
    val birthday: String? = null,

    @SerialName("gender")
    val gender: Int? = null,

    @SerialName("imdb_id")
    val imdbId: String? = null,

    @SerialName("known_for_department")
    val knownForDepartment: String? = null,

    @SerialName("profile_path")
    val profilePath: String? = null,

    @SerialName("biography")
    val biography: String? = null,

    @SerialName("deathday")
    val deathday: String? = null,

    @SerialName("place_of_birth")
    val placeOfBirth: String? = null,

    @SerialName("popularity")
    val popularity: Double? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("id")
    val id: Int? = null,

    @SerialName("adult")
    val adult: Boolean? = null,

    @SerialName("homepage")
    val homepage: String? = null
)
