package uz.rdo.themovie.ui.mainpages

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSizeWithPadding
import uz.rdo.coreui.composable.base.textfields.SearchTextFieldRounded
import uz.rdo.coreui.composable.base.texts.Text16spSecondary
import uz.rdo.coreui.composable.views.MoviesGrid
import uz.rdo.remote.data.response.MovieItem
import uz.rdo.themovie.ui.viewmodels.MainViewModel

@Composable
fun PopularMoviesScreen(viewModel: MainViewModel) {
    LaunchedEffect(key1 = Unit, block = {
        viewModel.getPopularMovies()
    })

    viewModel.popularMoviesState.value?.let { PopularMoviesScreenView(it) }
}

@Composable
fun PopularMoviesScreenView(popularMovies: List<MovieItem?>) {
    ColumnFillMaxSizeWithPadding {
        SearchTextFieldRounded() {
        }
        Text16spSecondary(text = "Popular")
        MoviesGrid(
            items = popularMovies,
            nextPage = { Log.d("TAG_090", "PopularMoviesScreenView: size size next page Handle") },
            onclick = {

            }
        )

    }
}


