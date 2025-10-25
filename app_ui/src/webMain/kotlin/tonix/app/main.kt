package tonix.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import tonix.app.di.appModules
import tonix.app.koin.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin(appModules)
    val appNavigationContext = DefaultComponentContext(lifecycle = LifecycleRegistry())
    ComposeViewport {
        App(appNavigationContext)
    }
}