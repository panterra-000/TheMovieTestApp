package uz.rdo.coreui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PrimaryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: TheMovieColors = ThemeColor.getColors(darkTheme),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalShapes provides TheMovieShapes(),
        LocalComposable provides TheMovieComposable(),
        LocalOverScrollConfiguration provides null
    ) {
        CompositionLocalProvider(
            LocalColors provides colors,
            LocalShapes provides TheMovieShapes(),
            LocalComposable provides TheMovieComposable(),
            LocalOverScrollConfiguration provides null
        ) {
            MaterialTheme(
                colors = MaterialTheme.colors.copy(
                    primary = colors.primary,
                    primaryVariant = colors.primaryVariant,
                    surface = colors.surface,
                    onPrimary = colors.primaryButtonText,
                    onSurface = colors.secondaryText,
                    onBackground = colors.primaryButtonBackground,
                ),
                typography = Typography,
                shapes = Shapes,
                content = content
            )

            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = TheMovieTheme.colors.statusBar
            )
        }
    }

}

@Immutable
data class TheMovieColors(
    val statusBar: Color,
    val primary: Color,
    val primaryVariant: Color,
    val surface: Color,
    val primaryButtonText: Color,
    val secondaryText: Color,
    val primaryButtonBackground: Color,
    val secondaryButtonText: Color,
    val additionalText: Color,
    val primaryText: Color,
    val secondaryButtonBackground: Color,
    val activeIconTint: Color,
    val inactiveIconTint: Color,
    val indicatorTint: Color,
)

val LocalColors = staticCompositionLocalOf<TheMovieColors> {
    error("No LocalColors specified")
}

val LocalShapes = staticCompositionLocalOf<TheMovieShapes> {
    error("No LocalShapes specified")
}


val LocalComposable = staticCompositionLocalOf<TheMovieComposable> {
    error("No LocalComposable specified")
}

@Immutable
data class TheMovieComposable(
    val welcomeBackground: @Composable (
    BoxScope.(
        startAnimation: Boolean,
        statusText: String?,
        onVendorFallbackInitiated: () -> Unit,
        onAnimationFinished: () -> Unit
    ) -> Unit
    )? = null
)

@Immutable
data class TheMovieShapes(
    val menuButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val keypadButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val primaryButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val secondaryButton: CornerBasedShape = RoundedCornerShape(8.dp),
    val alertDialog: CornerBasedShape = RoundedCornerShape(8.dp),
    val keypadComponent: CornerBasedShape = RoundedCornerShape(8.dp),
    val bottomSheetShape: CornerBasedShape = RoundedCornerShape(
        topStart = 18.dp,
        topEnd = 18.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
)

object TheMovieTheme {

    val colors: TheMovieColors
        @Composable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: TheMovieShapes
        @Composable
        get() = LocalShapes.current

    val composable: TheMovieComposable
        @Composable
        get() = LocalComposable.current


//    const val upperCaseButtons: Boolean = ThemeMisc.upperCaseButtons

//    fun contactSupportDetails(context: Context): CharSequence {
//        val phone = context.getText(string.support_contact_phone_number)
//        val email = context.getText(string.support_contact_email_address)
//        return phone.ifEmpty { email }
//    }
}