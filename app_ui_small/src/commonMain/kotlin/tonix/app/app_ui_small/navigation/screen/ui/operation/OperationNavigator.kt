package tonix.app.app_ui_small.navigation.screen.ui.operation

import tonix.app.app_ui_small.navigation.screen.navigator.AppScreensNavigator

internal interface OperationNavigator {
}

internal class OperationNavigatorImpl(
    private val appScreensNavigator: AppScreensNavigator
): OperationNavigator