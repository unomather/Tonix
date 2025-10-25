package tonix.app.app_ui_small.navigation.screen.navigator

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface AppScreensConfig {
    /** START **/
    @Serializable
    data object SplashConfig: AppScreensConfig
}