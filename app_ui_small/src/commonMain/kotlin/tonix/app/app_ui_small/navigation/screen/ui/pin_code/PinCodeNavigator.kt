package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface PinCodeNavigator {
    fun toCreateWallet()
}

internal class PinCodeNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): PinCodeNavigator {
    override fun toCreateWallet() {

    }
}