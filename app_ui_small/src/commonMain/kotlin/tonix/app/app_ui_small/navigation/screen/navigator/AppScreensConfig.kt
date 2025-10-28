package tonix.app.app_ui_small.navigation.screen.navigator

import kotlinx.serialization.Serializable
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenType

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
    data class SuccessConfig(val type: SuccessScreenType): AppScreensConfig

    @Serializable
    data object AssetsConfig: AppScreensConfig
}