package tonix.app.app_ui_small.navigation.screen.ui.operation

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface OperationIntent: BaseIntent

internal sealed interface OperationState: BaseState {
    data object Default: OperationState
}

internal sealed interface OperationAction: BaseAction

internal interface OperationListener