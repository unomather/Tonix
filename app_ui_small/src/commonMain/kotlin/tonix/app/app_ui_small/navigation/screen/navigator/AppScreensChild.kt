package tonix.app.app_ui_small.navigation.screen.navigator

import tonix.app.app_ui_small.navigation.base.BaseChild
import tonix.app.app_ui_small.navigation.base.BaseChildComponent
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletComponent
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeComponent
import tonix.app.app_ui_small.navigation.screen.ui.splash.SplashComponent

internal sealed class AppScreensChild(
    open val component: BaseChildComponent<*, *, *, *>,
    override val isSystemBackEnabled: Boolean = true
): BaseChild(isSystemBackEnabled) {
    /** START **/
    data class SplashChild(override val component: SplashComponent): AppScreensChild(component)

    /** CREATE IMPORT WALLET **/
    data class CreateImportWalletChild(
        override val component: CreateImportWalletComponent
    ): AppScreensChild(component)

    data class ImportWalletChild(override val component: ImportWalletComponent): AppScreensChild(component)

    /** PIN CODE **/
    data class PinCodeChild(override val component: PinCodeComponent): AppScreensChild(component)
}