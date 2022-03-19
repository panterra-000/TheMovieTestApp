package uz.rdo.coreui.composable.base

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun Spacer2dp() {
    Spacer(modifier = Modifier.size(2.dp))
}

@Composable
fun Spacer4dp() {
    Spacer(modifier = Modifier.size(4.dp))
}

@Composable
fun Spacer10dp() {
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun Spacer15dp() {
    Spacer(modifier = Modifier.size(15.dp))
}

@Composable
fun Spacer20dp() {
    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
fun Spacer30dp() {
    Spacer(modifier = Modifier.size(30.dp))
}

@Composable
fun Spacer36dp() {
    Spacer(modifier = Modifier.size(36.dp))
}

@Composable
fun Spacer48dp() {
    Spacer(modifier = Modifier.size(48.dp))
}

@Composable
fun Spacer50dp() {
    Spacer(modifier = Modifier.size(50.dp))
}

@Composable
fun ColumnScope.FillAvailableSpacer(percent:Float = 1f) {
    Spacer(modifier = Modifier.weight(percent))
}


@Composable
fun Spacer150dp() {
    Spacer(modifier = Modifier.size(150.dp))
}

@Composable
fun RowScope.FillAvailableSpacer(percent:Float = 1f) {
    Spacer(modifier = Modifier.weight(percent))
}