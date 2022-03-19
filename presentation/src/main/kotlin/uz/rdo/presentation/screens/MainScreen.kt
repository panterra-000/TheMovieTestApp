package uz.rdo.presentation.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import uz.rdo.coreui.composable.base.columns.ColumnFillMaxSize
import uz.rdo.coreui.composable.base.viewpager.HorizontalPagerWithTabRow
import uz.rdo.coreui.composable.views.AppBarView
import uz.rdo.coreui.R
import uz.rdo.presentation.mainpages.PopularMoviesScreen
import uz.rdo.presentation.mainpages.TopRatedMoviesScreen
import uz.rdo.presentation.mainpages.UpcomingMoviesScreen
import uz.rdo.remote.data.response.MovieItem

@ExperimentalPagerApi
@Composable
fun MainScreen(navController: NavController) {
    val context = LocalContext.current

    MainScreenView() { movieItem ->
//        navController.navigateUp()
        Toast.makeText(
            context,
            "clicked Movie:id = ${movieItem.id},  title = ${movieItem.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}

@ExperimentalPagerApi
@Composable
fun MainScreenView(clickMovieItem: (MovieItem) -> Unit) {
    val pageTitles = listOf(
        stringResource(id = R.string._search),
        stringResource(id = R.string._title_top_rated),
        stringResource(id = R.string._title_upcoming)
    )
    ColumnFillMaxSize {
        AppBarView(title = stringResource(R.string._title_movies))
        HorizontalPagerWithTabRow(pageTitles) { page ->
            when (page) {
                0 -> {
                    PopularMoviesScreen() { movieItem ->
                        clickMovieItem(movieItem)
                    }
                }
                1 -> {
                    TopRatedMoviesScreen() { movieItem ->
                        clickMovieItem(movieItem)

                    }
                }
                else -> {
                    UpcomingMoviesScreen() { movieItem ->
                        clickMovieItem(movieItem)
                    }
                }
            }
        }
    }
}