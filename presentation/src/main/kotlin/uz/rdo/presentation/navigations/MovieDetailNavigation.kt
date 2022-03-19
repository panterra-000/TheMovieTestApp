package uz.rdo.presentation.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import uz.rdo.coreui.MOVIE_DETAIL_SCREEN_ROUTE
import uz.rdo.coreui.navigation.ScreenNavigationSpec
import uz.rdo.presentation.screens.MovieDetailScreen

@ExperimentalUnitApi
object MovieDetailNavigation : ScreenNavigationSpec {

    override val route: String
        get() = MOVIE_DETAIL_SCREEN_ROUTE

    @ExperimentalPagerApi
    @ExperimentalComposeUiApi
    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
    ) {
        MovieDetailScreen(navController)
    }

}