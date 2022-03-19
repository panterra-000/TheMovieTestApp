package uz.rdo.themovie.ui.mainpages

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.views.AppLoaderCenter
import uz.rdo.coreui.composable.views.MoviesGrid
import uz.rdo.remote.data.response.MovieItem
import uz.rdo.themovie.ui.viewmodels.PopularMoviesViewModel

@Composable
fun PopularMoviesScreen(viewModel: PopularMoviesViewModel) {

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
//        SearchTextFieldRounded() {
//        }
        MoviesGrid(
            items = popularMovies,
            nextPage = { nextPage() },
            onclick = {
                itemClick(it)
            }
        )

    }
}


