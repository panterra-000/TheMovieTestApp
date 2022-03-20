package uz.rdo.remote.data.response.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@kotlinx.serialization.Serializable
data class ActorMovieCreditsResponse(

	@SerialName("cast")
	val cast: List<MovieCastItem?>? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("crew")
	val crew: List<CrewItem?>? = null
)

@kotlinx.serialization.Serializable
data class MovieCastItem(

	@SerialName("overview")
	val overview: String? = null,

	@SerialName("original_language")
	val originalLanguage: String? = null,

	@SerialName("original_title")
	val originalTitle: String? = null,

	@SerialName("video")
	val video: Boolean? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("genre_ids")
	val genreIds: List<Int?>? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null,

	@SerialName("character")
	val character: String? = null,

	@SerialName("release_date")
	val releaseDate: String? = null,

	@SerialName("credit_id")
	val creditId: String? = null,

	@SerialName("vote_average")
	val voteAverage: Double? = null,

	@SerialName("popularity")
	val popularity: Double? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("adult")
	val adult: Boolean? = null,

	@SerialName("vote_count")
	val voteCount: Int? = null,

	@SerialName("order")
	val order: Int? = null
)

@Serializable
data class CrewItem(

	@SerialName("overview")
	val overview: String? = null,

	@SerialName("original_language")
	val originalLanguage: String? = null,

	@SerialName("original_title")
	val originalTitle: String? = null,

	@SerialName("video")
	val video: Boolean? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("genre_ids")
	val genreIds: List<Int?>? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null,

	@SerialName("release_date")
	val releaseDate: String? = null,

	@SerialName("credit_id")
	val creditId: String? = null,

	@SerialName("vote_average")
	val voteAverage: Double? = null,

	@SerialName("popularity")
	val popularity: Double? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("adult")
	val adult: Boolean? = null,

	@SerialName("department")
	val department: String? = null,

	@SerialName("job")
	val job: String? = null,

	@SerialName("vote_count")
	val voteCount: Int? = null
)
