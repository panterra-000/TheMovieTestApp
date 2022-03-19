package uz.rdo.coreui.composable.base.textfields

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.rdo.coreui.R
import uz.rdo.coreui.composable.base.Spacer10dp
import uz.rdo.coreui.composable.base.texts.Text16spSecondary
import uz.rdo.coreui.theme.TheMovieTheme

@Composable
fun SearchTextField(
    textState: MutableState<String>,
    hintText: String = stringResource(R.string._search),
    @DrawableRes iconId: Int = R.drawable.ic_search,
    defMarginTop: Boolean = false,
    defMarginBottom: Boolean = false,
    textChanged: (String) -> Unit
) {
    Column {
        if (defMarginTop) Spacer10dp()
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState.value,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                disabledLabelColor = Color.Transparent,
                focusedIndicatorColor = TheMovieTheme.colors.inactiveIconTint,
                unfocusedIndicatorColor = TheMovieTheme.colors.inactiveIconTint
            ),
            textStyle = TextStyle(color = TheMovieTheme.colors.primaryText, fontSize = 16.sp),
            onValueChange = {
                textState.value = it
                if (it.length > 1) {
                    textChanged(it)
                }
            },
            singleLine = true,
            placeholder = {
                Text16spSecondary(
                    hintText,
                    color = TheMovieTheme.colors.secondaryText
                )
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(painter = painterResource(id = iconId), contentDescription = null)
                }
            }
        )
        if (defMarginBottom) Spacer10dp()
    }
}



@Composable
fun SearchTextFieldRounded(
    valueChange: (String) -> Unit
) {
    val textState = remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                shape = RoundedCornerShape(12.dp)
                clip = true
            }
    ) {
        Row(
            Modifier
                .background(TheMovieTheme.colors.secondaryButtonBackground)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
            Spacer10dp()
            BasicTextField(
                value = textState.value,
                onValueChange = { textState.value = it; valueChange(it) },
                textStyle = TextStyle(color = TheMovieTheme.colors.primaryText, fontSize = 14.sp),
                singleLine = true,
            )
        }
    }
}