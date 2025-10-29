package tonix.app.app_ui_small.navigation.screen.ui.market

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface MarketNavigator

internal class MarketNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): MarketNavigator