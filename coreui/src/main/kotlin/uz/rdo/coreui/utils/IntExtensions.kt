package uz.rdo.coreui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.rdo.coreui.R

@Composable
fun Int.getGenderFromApi(): String {
    return when (this) {
        1 -> {
            stringResource(id = R.string._gender_female)
        }
        2 -> {
            stringResource(id = R.string._gender_male)
        }
        else -> {
            ""
        }
    }
}