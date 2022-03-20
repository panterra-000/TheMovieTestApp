package uz.rdo.coreui.composable.base.texts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LabeledRowText(label: String, value: String) {
    Row(Modifier.padding(vertical = 5.dp)) {
        Text14spSecondary(text = label)
        Spacer(modifier = Modifier.weight(1f))
        Text14sp(text = value)
    }
}