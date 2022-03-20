package uz.rdo.coreui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.rdo.coreui.R

const val HOUR_TO_MINUTE = 60

@Composable
fun Int.timeSeparation(): String {
    val h = stringResource(id = R.string._hour)
    val m = stringResource(id = R.string._minute)
    return "${this / HOUR_TO_MINUTE}$h ${this % HOUR_TO_MINUTE}$m"
}