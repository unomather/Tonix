package tonix.app.app_ui_small.navigation

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface AppIntent: BaseIntent

internal sealed interface AppState: BaseState {
    data object Default: AppState
}

internal sealed interface AppAction: BaseAction

internal interface AppListener