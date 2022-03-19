package uz.rdo.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.coroutines.InternalCoroutinesApi
import uz.rdo.coreui.MAIN_GRAPH_ROUTE
import uz.rdo.coreui.MAIN_SCREEN_ROUTE
import uz.rdo.presentation.navigations.ActorDetailNavigation
import uz.rdo.presentation.navigations.MainNavigation
import uz.rdo.presentation.navigations.MovieDetailNavigation

@OptIn(ExperimentalComposeUiApi::class)
@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalUnitApi
fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    navigation(route = MAIN_GRAPH_ROUTE, startDestination = MAIN_SCREEN_ROUTE) {
        listOf(
            MainNavigation,
            MovieDetailNavigation,
            ActorDetailNavigation
        ).forEach { screen ->
            composable(
                screen.route,
                screen.arguments,
                screen.deepLinks,
            ) {

//                val navigationGraphEntry = remember {
//                    return@remember navController.getBackStackEntry(MAIN_GRAPH_ROUTE)
//                }

                screen.Content(
                    navController = navController,
                    navBackStackEntry = it,
                )
            }
        }
    }
}