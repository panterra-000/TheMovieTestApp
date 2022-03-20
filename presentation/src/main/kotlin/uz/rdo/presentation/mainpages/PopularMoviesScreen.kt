package uz.rdo.presentation.mainpages

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.views.AppLoaderCenter
import uz.rdo.coreui.composable.customviews.MoviesGrid
import uz.rdo.coreui.viewdata.MovieItemViewData
import uz.rdo.coreui.viewdata.movieMapper
import uz.rdo.remote.data.response.movie.MovieItem
import uz.rdo.presentation.viewmodels.mainscreen.PopularMoviesViewModel

@Composable
fun PopularMoviesScreen(
    viewModel: PopularMoviesViewModel = hiltViewModel(),
    onMovieClick: (MovieItemViewData) -> Unit
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getPopularMovies()
    })

    LaunchedEffect(key1 = Unit, block = {
        viewModel.errorState.collect {
            Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    })

    viewModel.popularMoviesState.value?.let {
        PopularMoviesScreenView(
            it,
            nextPage = { viewModel.getPopularMovies() },
            itemClick = { movie ->
                onMovieClick(movie)
            }
        )
    }

    if (viewModel.loaderState.value) {
        AppLoaderCenter()
    }
}

@Composable
fun PopularMoviesScreenView(
    popularMovies: List<MovieItem?>,
    nextPage: () -> Unit,
    itemClick: (MovieItemViewData) -> Unit
) {
    ColumnFillMaxSizeWithPadding {
//        SearchTextFieldRounded() {
//        }
        MoviesGrid(
            itemData = popularMovies.movieMapper(),
            nextPage = { nextPage() },
            onclick = {
                itemClick(it)
            }
        )

    }
}


