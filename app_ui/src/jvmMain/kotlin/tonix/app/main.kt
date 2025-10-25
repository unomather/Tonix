package tonix.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import tonix.app.di.appModules
import tonix.app.koin.initKoin

fun main() = application {
    initKoin(appModules)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tonix",
    ) {
        App()
    }
}