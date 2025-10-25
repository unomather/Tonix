package tonix.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import tonix.app.di.appModules
import tonix.app.koin.initKoin

fun main() = application {
    initKoin(appModules)
    val appNavigationContext = DefaultComponentContext(lifecycle = LifecycleRegistry())
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tonix",
    ) {
        App(appNavigationContext)
    }
}