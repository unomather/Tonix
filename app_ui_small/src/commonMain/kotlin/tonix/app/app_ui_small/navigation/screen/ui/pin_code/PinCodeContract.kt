package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem

internal sealed interface PinCodeIntent: BaseIntent

internal data class PinCodeState(
    val title: String = "",
    val pinCodeItems: List<PinCodeItem> = listOf(),
    val isForgotPinCodeTextVisible: Boolean = false
): BaseState

internal sealed interface PinCodeAction: BaseAction

internal sealed interface PinCodeListener