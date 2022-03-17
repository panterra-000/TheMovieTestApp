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
        statusBarColor = Color(0x80000000)
    )

    private val themeDark = TheMovieColors(
        statusBarColor = Color(0x80000000)
    )

}