package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode

internal interface CreateImportWalletNavigator {
    fun toCreatePinCode()
    fun toImportWallet()
}

internal class CreateImportWalletNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): CreateImportWalletNavigator {
    override fun toCreatePinCode() {
        appScreensNavigator.toPinCode(PinCodeMode.CREATE)
    }

    override fun toImportWallet() {
        appScreensNavigator.toImportWallet()
    }
}