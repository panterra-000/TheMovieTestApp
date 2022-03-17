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
        statusBarColor = Color(0xff000000),
        primaryColor = Color(0xFF6D1010)
    )

    private val themeDark = TheMovieColors(
        statusBarColor = Color(0xff000000),
        primaryColor = Color(0xFF6B1212)
    )

}