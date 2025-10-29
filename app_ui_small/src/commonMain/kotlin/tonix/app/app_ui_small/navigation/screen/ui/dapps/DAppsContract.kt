package tonix.app.app_ui_small.navigation.screen.ui.dapps

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface DAppsIntent: BaseIntent

internal sealed interface DAppsState: BaseState {
    data object Default: DAppsState
}

internal sealed interface DAppsAction: BaseAction

internal interface DAppsListener