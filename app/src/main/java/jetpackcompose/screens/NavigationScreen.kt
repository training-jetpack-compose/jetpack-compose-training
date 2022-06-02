package jetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jetpackcompose.R
import jetpackcompose.router.Router.navigateTo
import jetpackcompose.router.Screen
import jetpackcompose.router.Router


@Composable
fun NavigationScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Router.screens.map {
                NavigationButton(
                    stringResource(it.first),
                    it.second
                )
            }
        }
    }
}

@Composable
fun NavigationButton(text: String, screen: Screen) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            ),
        shape = RoundedCornerShape(4.dp),
        colors = buttonColors(backgroundColor = colorResource(id = R.color.colorPrimary)),
        onClick = { navigateTo(screen) }
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}