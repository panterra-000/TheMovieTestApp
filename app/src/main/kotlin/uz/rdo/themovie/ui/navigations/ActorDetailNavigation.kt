package uz.rdo.themovie.ui.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import uz.rdo.coreui.ACTOR_DETAIL_SCREEN_ROUTE
import uz.rdo.coreui.MAIN_SCREEN_ROUTE
import uz.rdo.coreui.navigation.ScreenNavigationSpec
import uz.rdo.themovie.ui.screens.ActorDetailScreen
import uz.rdo.themovie.ui.screens.MainScreen

@ExperimentalUnitApi
object ActorDetailNavigation : ScreenNavigationSpec {

    override val route: String
        get() = ACTOR_DETAIL_SCREEN_ROUTE

    @ExperimentalPagerApi
    @ExperimentalComposeUiApi
    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
    ) {
        ActorDetailScreen(navController)
    }

}