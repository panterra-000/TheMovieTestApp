package uz.rdo.presentation.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi
import uz.rdo.coreui.ACTOR_DETAIL_SCREEN_ROUTE
import uz.rdo.coreui.navigation.ScreenNavigationSpec
import uz.rdo.presentation.screens.ActorDetailScreen

@ExperimentalUnitApi
object ActorDetailNavigation : ScreenNavigationSpec {

    private const val ACTOR_ID = "actor_id"

    override val route: String
        get() = "$ACTOR_DETAIL_SCREEN_ROUTE/{$ACTOR_ID}"

    fun createRoute(actorId: Int) = "$ACTOR_DETAIL_SCREEN_ROUTE/$actorId"

    @ExperimentalPagerApi
    @ExperimentalComposeUiApi
    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @Composable
    override fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
    ) {
        ActorDetailScreen(
            actorId = navBackStackEntry.arguments?.getString(ACTOR_ID) ?: "0",
            navController = navController
        )
    }

}