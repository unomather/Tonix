package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface CreateImportWalletNavigator {
    fun toCreateWallet()
    fun toImportWallet()
}

internal class CreateImportWalletNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): CreateImportWalletNavigator {
    override fun toCreateWallet() {

    }

    override fun toImportWallet() {
        appScreensNavigator.toImportWallet()
    }
}