package uz.rdo.themovie.ui.mainpages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.base.textfields.SearchTextFieldRounded
import uz.rdo.coreui.composable.views.AppLoaderCenter
import uz.rdo.coreui.composable.views.MoviesGrid
import uz.rdo.remote.data.response.MovieItem
import uz.rdo.themovie.ui.viewmodels.MainViewModel

@Composable
fun PopularMoviesScreen(viewModel: MainViewModel) {
    LaunchedEffect(key1 = Unit, block = {
        viewModel.getPopularMovies()
    })

    viewModel.popularMoviesState.value?.let {
        PopularMoviesScreenView(
            it,
            nextPage = { viewModel.getPopularMovies() },
            itemClick = {}
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
    itemClick: (MovieItem) -> Unit
) {
    ColumnFillMaxSizeWithPadding {
        SearchTextFieldRounded() {
        }
        MoviesGrid(
            items = popularMovies,
            nextPage = { nextPage() },
            onclick = {
                itemClick(it)
            }
        )

    }
}


