package tonix.app.app_ui_small.navigation.screen.navigator

import kotlinx.serialization.Serializable
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode

@Serializable
internal sealed interface AppScreensConfig {
    @Serializable
    data object SplashConfig: AppScreensConfig

    @Serializable
    data object CreateImportWalletConfig: AppScreensConfig

    @Serializable
    data object ImportWalletConfig: AppScreensConfig

    @Serializable
    data class PinCodeConfig(val mode: PinCodeMode): AppScreensConfig

    @Serializable
    data object OperationConfig: AppScreensConfig
}