package tonix.app.app_ui_small.navigation.screen.ui.success

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface SuccessNavigator {
    fun toAssets()
}

internal class SuccessNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): SuccessNavigator {
    override fun toAssets() {
        appScreensNavigator.toAssets()
    }
}