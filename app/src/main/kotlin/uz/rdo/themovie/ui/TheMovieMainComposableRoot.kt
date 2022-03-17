package uz.rdo.themovie.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.InternalCoroutinesApi
import uz.rdo.coreui.MAIN_GRAPH_ROUTE
import uz.rdo.coreui.MAIN_SCREEN_ROUTE
import uz.rdo.coreui.theme.PrimaryTheme

@ExperimentalUnitApi
@ExperimentalFoundationApi
@InternalCoroutinesApi
@Composable
fun TheMovieMainComposableRoot() {
    val navController: NavHostController = rememberNavController()
    PrimaryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = navController,
                startDestination = MAIN_GRAPH_ROUTE
            ) {
                mainGraph(navController = navController)
            }
        }
    }
}