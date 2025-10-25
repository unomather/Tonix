package tonix.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import tonix.app.di.appModules
import tonix.app.koin.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin(appModules)
    ComposeViewport {
        App()
    }
}