package jetpackcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpackcompose.R
import jetpackcompose.router.BackButtonHandler
import jetpackcompose.router.Router.navigateTo
import jetpackcompose.router.Screen

@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DemoButton()
        DemoRadioGroup()
        DemoFloatingActionButton()
    }
    BackButtonHandler { navigateTo(Screen.Navigation) }
}

@Preview
@Composable
fun DemoButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor =
            colorResource(id = R.color.colorPrimary)
        ),
        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.colorPrimaryDark)
        )
    ) {
        Text(
            text = stringResource(id = R.string.button_text),
            color = Color.White
        )
    }

}

@Preview
@Composable
fun DemoRadioGroup() {
    val radioButtons = listOf(0, 1, 2)
    val selectedButton = remember { mutableStateOf(radioButtons.first()) }
    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.colorPrimary),
                unselectedColor = colorResource(id = R.color.colorPrimaryDark),
                disabledColor = Color.LightGray
            )
            RadioButton(
                colors = colors,
                selected = isSelected,
                onClick = { selectedButton.value = index }
            )
        }
    }
}

@Preview
@Composable
fun DemoFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = colorResource(id =
        R.color.colorPrimary),
        contentColor = Color.White,
        content = {
            Icon(Icons.Filled.Favorite, contentDescription = "Test FAB")
        }
    )
}