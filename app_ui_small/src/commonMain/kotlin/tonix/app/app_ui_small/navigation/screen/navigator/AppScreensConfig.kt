package tonix.app.app_ui_small.navigation.screen.navigator

import kotlinx.serialization.Serializable
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode

@Serializable
internal sealed interface AppScreensConfig {
    /** START **/
    @Serializable
    data object SplashConfig: AppScreensConfig

    /** CREATE IMPORT WALLET **/
    @Serializable
    data object CreateImportWalletConfig: AppScreensConfig

    @Serializable
    data object ImportWalletConfig: AppScreensConfig

    /** PIN CODE **/
    @Serializable
    data class PinCodeConfig(val mode: PinCodeMode): AppScreensConfig
}