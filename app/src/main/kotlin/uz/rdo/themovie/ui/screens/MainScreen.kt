package uz.rdo.themovie.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.base.viewpager.HorizontalPagerWithTabRow
import uz.rdo.coreui.composable.views.AppBarView
import uz.rdo.themovie.R
import uz.rdo.themovie.ui.mainpages.PopularMoviesScreen
import uz.rdo.themovie.ui.mainpages.TopRatedMoviesScreen
import uz.rdo.themovie.ui.mainpages.UpcomingMoviesScreen
import uz.rdo.themovie.ui.viewmodels.PopularMoviesViewModel

@ExperimentalPagerApi
@Composable
fun MainScreen(navController: NavController, viewModel: PopularMoviesViewModel = hiltViewModel()) {
    MainScreenView(viewModel)
}

@ExperimentalPagerApi
@Composable
fun MainScreenView(viewModel: PopularMoviesViewModel) {
    val pageTitles = listOf(
        stringResource(id = R.string._title_popular),
        stringResource(id = R.string._title_top_rated),
        stringResource(id = R.string._title_upcoming)
    )
    ColumnFillMaxSize {
        AppBarView(title = stringResource(R.string._title_movies))
        HorizontalPagerWithTabRow(pageTitles) { page ->
            when (page) {
                0 -> {
                    PopularMoviesScreen(viewModel = viewModel)
                }
                1 -> {
                    TopRatedMoviesScreen(viewModel = viewModel)
                }
                else -> {
                    UpcomingMoviesScreen(viewModel = viewModel)
                }
            }
        }
    }
}