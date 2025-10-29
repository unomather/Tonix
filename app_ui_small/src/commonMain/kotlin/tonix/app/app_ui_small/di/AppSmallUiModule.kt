package tonix.app.app_ui_small.di

import tonix.app.app_ui_small.di.bottom_navigation.moduleAppSmallUiBottomNavigation
import tonix.app.app_ui_small.di.component.moduleAppSmallUiComponents
import tonix.app.app_ui_small.di.navigator.moduleAppSmallUiNavigators
import tonix.app.app_ui_small.di.view_model.moduleAppSmallUiViewModel

val moduleAppSmallUi = listOf(
    moduleAppSmallUiViewModel,
    moduleAppSmallUiComponents,
    moduleAppSmallUiNavigators,
    moduleAppSmallUiBottomNavigation
)