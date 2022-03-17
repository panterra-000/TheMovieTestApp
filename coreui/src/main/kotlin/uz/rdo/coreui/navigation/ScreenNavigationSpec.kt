package uz.rdo.coreui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*

interface ScreenNavigationSpec {
    val route: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()

    val navOptions: NavOptions
        get() = NavOptions.Builder().build()

    @Composable
    fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
    )
}
