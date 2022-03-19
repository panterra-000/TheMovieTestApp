package uz.rdo.themovie.ui.mainpages

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.views.AppLoaderCenter
import uz.rdo.coreui.composable.views.MoviesGrid
import uz.rdo.remote.data.response.MovieItem
import uz.rdo.themovie.ui.viewmodels.UpcomingMoviesViewModel

@Composable
fun UpcomingMoviesScreen(
    viewModel: UpcomingMoviesViewModel = hiltViewModel(),
    onMovieClick: (MovieItem) -> Unit
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getUpcomingMovies()
    })

    LaunchedEffect(key1 = Unit, block = {
        viewModel.errorState.collect {
            Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    })

    viewModel.moviesState.value?.let {
        UpcomingMoviesScreenView(
            it,
            nextPage = { viewModel.getUpcomingMovies() },
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
fun UpcomingMoviesScreenView(
    popularMovies: List<MovieItem?>,
    nextPage: () -> Unit,
    itemClick: (MovieItem) -> Unit
) {
    ColumnFillMaxSizeWithPadding {
        MoviesGrid(
            items = popularMovies,
            nextPage = { nextPage() },
            onclick = {
                itemClick(it)
            }
        )
    }
}

