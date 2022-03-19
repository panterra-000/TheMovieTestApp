package uz.rdo.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.views.AppBarViewWithIcons
import uz.rdo.presentation.viewmodels.MovieDetailViewModel
import uz.rdo.remote.data.response.detail.MovieDetailResponse

@Composable
fun MovieDetailScreen(
    movieId: Long,
    navController: NavController,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    MovieDetailScreenView(movieDetailResponse = null) {
        navController.navigateUp()
    }
}

@Composable
fun MovieDetailScreenView(movieDetailResponse: MovieDetailResponse?, backClick: () -> Unit) {
    ColumnFillMaxSize {
        AppBarViewWithIcons(title = stringResource(R.string._title_detail),
            startIconClick = {

            })
    }
}