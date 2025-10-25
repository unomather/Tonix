package tonix.app.app_ui_small.navigation

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface AppNavigator {
    val appScreensNavigator: AppScreensNavigator
}

internal data class AppNavigatorImpl(
    override val appScreensNavigator: AppScreensNavigator
): AppNavigator