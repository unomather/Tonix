package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenType.WALLET_SUCCESSFULLY_CREATED

internal interface PinCodeNavigator {
    fun back()
    fun toWalletSuccessfullyCreated()
}

internal class PinCodeNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): PinCodeNavigator {
    override fun back() {
        appScreensNavigator.navigateBack()
    }

    override fun toWalletSuccessfullyCreated() {
        appScreensNavigator.toSuccess(type = WALLET_SUCCESSFULLY_CREATED)
    }
}