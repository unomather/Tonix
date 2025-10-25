package tonix.app

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import tonix.app.di.appModules
import tonix.app.koin.initKoin

fun MainViewController(): UIViewController {
    initKoin(appModules)
    return ComposeUIViewController {
        App()
    }
}