package tonix.app.app_ui_small.navigation.screen.ui.splash

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceAll
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig
import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensConfig.CreateImportWalletConfig

internal interface SplashNavigator {
    fun toCreateImportWallet()
}

internal class SplashNavigatorImpl(
    private val navigation: StackNavigation<AppScreensConfig>
): SplashNavigator {
    override fun toCreateImportWallet() {
        navigation.replaceAll(CreateImportWalletConfig)
    }
}