package tonix.app.app_ui_small.navigation.screen.navigator

import tonix.app.app_ui_small.navigation.base.BaseChild

internal sealed class AppScreensChild(
    override val isSystemBackEnabled: Boolean = true
): BaseChild(isSystemBackEnabled) {
    /** START **/
    data object SplashChild: AppScreensChild()
}