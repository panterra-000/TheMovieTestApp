package uz.rdo.coreui.theme

import androidx.compose.ui.graphics.Color

object ThemeColor {

    fun getColors(darkTheme: Boolean): TheMovieColors {
        return if (darkTheme) {
            themeDark
        } else {
            themeLight
        }
    }

    private val themeLight = TheMovieColors(
        statusBar = Color(0xff000000),
        primary = Color(0xff000000),
        primaryVariant = Color(0xff000000),
        surface = Color(0xff000000),

        primaryButtonText = Color(0xff000000),
        secondaryButtonText = Color(0xffffffff),

        primaryText = Color(0xffffffff),
        secondaryText = Color(0xff929294),
        additionalText = Color(0xff929294),

        primaryButtonBackground = Color(0xffFF9F0A),
        secondaryButtonBackground = Color(0xff2B2B2D),

        activeIconTint = Color(0xffffffff),
        inactiveIconTint = Color(0xff929294),
        indicatorTint = Color(0xffFF9F0A),
        primaryDividerBackground = Color(0xffFF9F0A),
    )

    private val themeDark = TheMovieColors(
        statusBar = Color(0xff000000),
        primary = Color(0xff000000),
        primaryVariant = Color(0xff000000),
        surface = Color(0xff000000),

        primaryButtonText = Color(0xff000000),
        secondaryButtonText = Color(0xffffffff),

        primaryText = Color(0xffffffff),
        secondaryText = Color(0xff929294),
        additionalText = Color(0xff929294),

        primaryButtonBackground = Color(0xffFF9F0A),
        secondaryButtonBackground = Color(0xff2B2B2D),

        activeIconTint = Color(0xffffffff),
        inactiveIconTint = Color(0xff929294),
        indicatorTint = Color(0xffFF9F0A),
        primaryDividerBackground = Color(0xffFF9F0A),
    )


}