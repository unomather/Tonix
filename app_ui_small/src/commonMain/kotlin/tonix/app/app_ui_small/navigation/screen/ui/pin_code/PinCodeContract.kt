package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface PinCodeIntent: BaseIntent

internal sealed interface PinCodeState: BaseState {
    data object Default: PinCodeState
}

internal sealed interface PinCodeAction: BaseAction

internal sealed interface PinCodeListener