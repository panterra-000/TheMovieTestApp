package uz.rdo.remote.data.response.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MoviesResponse(

	@SerialName("page")
	val page: Int? = null,

	@SerialName("total_pages")
	val totalPages: Int? = null,

	@SerialName("results")
	val results: List<MovieItem?>? = null,

	@SerialName("total_results")
	val totalResults: Int? = null
)

@Serializable
data class MovieItem(

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

	@SerialName("popularity")
	val popularity: Double? = null,

	@SerialName("vote_average")
	val voteAverage: Double? = null,

	@SerialName("id")
	val id: Long? = null,

	@SerialName("adult")
	val adult: Boolean? = null,

	@SerialName("vote_count")
	val voteCount: Int? = null
)
