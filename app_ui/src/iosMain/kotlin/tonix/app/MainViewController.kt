package tonix.app

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.backhandler.BackDispatcher
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import platform.UIKit.UIViewController
import tonix.app.di.appModules
import tonix.app.koin.initKoin

fun MainViewController(): UIViewController {
    initKoin(appModules)
    val backDispatcher = BackDispatcher()
    val appComponentContext = DefaultComponentContext(
        lifecycle = ApplicationLifecycle(),
        backHandler = backDispatcher
    )
    return ComposeUIViewController {
        App(appComponentContext)
    }
}