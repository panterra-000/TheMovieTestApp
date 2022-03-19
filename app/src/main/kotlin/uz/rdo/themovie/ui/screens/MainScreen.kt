package uz.rdo.themovie.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.base.viewpager.HorizontalPagerWithTabRow
import uz.rdo.coreui.composable.views.AppBarView
import uz.rdo.themovie.R
import uz.rdo.themovie.ui.viewmodels.MainViewModel

@ExperimentalPagerApi
@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getPopularMovies()
    })

    MainScreenView()

}

@ExperimentalPagerApi
@Composable
fun MainScreenView() {
    ColumnFillMaxSize {
        AppBarView(title = stringResource(R.string._title_movies))
        HorizontalPagerWithTabRow(listOf()) { page ->

        }
    }
}