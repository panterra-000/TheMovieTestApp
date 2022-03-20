package uz.rdo.coreui.viewdata

import uz.rdo.remote.data.response.actor.MovieCastItem
import uz.rdo.remote.data.response.movie.MovieItem

data class MovieItemViewData(
    val id: Long? = null,
    val title: String? = null,
    val posterPath: String? = null
)

fun List<MovieItem?>.movieMapper(): List<MovieItemViewData> {
    return this.map { movie ->
        MovieItemViewData(
            id = movie?.id,
            title = movie?.title,
            posterPath = movie?.posterPath
        )
    }
}

fun List<MovieCastItem?>.movieMapperWithCastMovie(): List<MovieItemViewData> {
    return this.map { movie ->
        MovieItemViewData(
            id = movie?.id,
            title = movie?.title,
            posterPath = movie?.posterPath
        )
    }
}