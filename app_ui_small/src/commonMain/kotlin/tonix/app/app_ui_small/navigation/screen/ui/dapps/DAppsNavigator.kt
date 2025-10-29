package tonix.app.app_ui_small.navigation.screen.ui.dapps

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface DAppsNavigator

internal class DAppsNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): DAppsNavigator