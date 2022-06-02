package jetpackcompose.router

import androidx.compose.runtime.mutableStateOf
import jetpackcompose.R
import jetpackcompose.router.Screen.Navigation

sealed class Screen {
    object Navigation : Screen()
    object Text : Screen()
    object TextField : Screen()
    object Buttons : Screen()
    object ProgressIndicator : Screen()
    object AlertDialog : Screen()
}


object Router {

    @JvmStatic
    val screens by lazy {
        arrayOf(
            Pair(R.string.text, Screen.Text),
            Pair(R.string.text_field, Screen.TextField),
            Pair(R.string.buttons, Screen.Buttons),
            Pair(R.string.progress_indicators, Screen.ProgressIndicator),
            Pair(R.string.alert_dialog, Screen.AlertDialog),
        )
    }

    @JvmStatic
    var currentScreen = mutableStateOf<Screen>(Navigation)

    @JvmStatic
    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}