package tonix.app.app_ui_small.navigation.screen.ui.success

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface SuccessIntent: BaseIntent

internal sealed interface SuccessState: BaseState {
    data object Default: SuccessState
}

internal sealed interface SuccessAction: BaseAction

internal interface SuccessListener