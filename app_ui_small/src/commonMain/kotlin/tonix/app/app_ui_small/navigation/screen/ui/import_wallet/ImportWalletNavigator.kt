package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface ImportWalletNavigator {
    fun back()
    fun toExistingWallet()
    fun toTestnetWallet()
}

internal class ImportWalletNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): ImportWalletNavigator {
    override fun back() {
        appScreensNavigator.navigateBack()
    }

    override fun toExistingWallet() {

    }

    override fun toTestnetWallet() {

    }
}