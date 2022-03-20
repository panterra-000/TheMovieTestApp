package uz.rdo.presentation.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.Spacer50dp
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.views.*
import uz.rdo.presentation.viewmodels.MovieDetailViewModel
import uz.rdo.remote.data.response.detail.MovieDetailResponse

@Composable
fun MovieDetailScreen(
    movieId: String,
    navController: NavController,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getMovieDetail(movieId)
    })

    LaunchedEffect(key1 = Unit, block = {
        viewModel.errorState.collect {
            Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    })

    viewModel.movieDetailState.value?.let {
        MovieDetailScreenView(movieDetailResponse = it) {
            navController.navigateUp()
        }
    }

    if (viewModel.loaderState.value) {
        AppLoaderCenter()
    }
}

@Composable
fun MovieDetailScreenView(movieDetailResponse: MovieDetailResponse, backClick: () -> Unit) {
    ColumnFillMaxSize {
        AppBarViewWithIcons(title = stringResource(R.string._title_detail),
            startIconClick = {
                backClick()
            })
//        BackDropImageWithAlpha(url = movieDetailResponse.backdropPath) {
//
//        }

        MovieHeaderWithImage(
            coverImgUrl = movieDetailResponse.backdropPath.toString(),
            posterImgUrl = movieDetailResponse.posterPath.toString(),
            title = movieDetailResponse.originalTitle.toString()
        )

    }
}