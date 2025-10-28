package tonix.app.app_ui_small.navigation.screen.ui.assets

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface AssetsNavigator

internal class AssetsNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): AssetsNavigator