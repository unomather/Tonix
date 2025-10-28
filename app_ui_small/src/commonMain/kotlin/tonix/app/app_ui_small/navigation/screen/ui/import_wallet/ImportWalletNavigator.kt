package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenType.WALLET_SUCCESSFULLY_IMPORTED

internal interface ImportWalletNavigator {
    fun back()
    fun toWalletSuccessfullyImported()
}

internal class ImportWalletNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): ImportWalletNavigator {
    override fun back() {
        appScreensNavigator.navigateBack()
    }

    override fun toWalletSuccessfullyImported() {
        appScreensNavigator.toSuccess(type = WALLET_SUCCESSFULLY_IMPORTED)
    }
}