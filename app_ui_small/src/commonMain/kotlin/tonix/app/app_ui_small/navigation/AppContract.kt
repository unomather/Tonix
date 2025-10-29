package tonix.app.app_ui_small.navigation

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem

internal sealed interface AppIntent: BaseIntent {
    data class SetBottomNavigationTab(val tab: BottomNavigationItem): AppIntent
}

internal data class AppState(
    val selectedBottomNavigationTab: BottomNavigationItem? = null
): BaseState

internal sealed interface AppAction: BaseAction

internal interface AppListener {
    fun selectBottomNavigationTab(tab: BottomNavigationItem)
}