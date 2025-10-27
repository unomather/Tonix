package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeDotsState
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem

internal const val PIN_CODE_LENGTH = 6

internal sealed interface PinCodeIntent: BaseIntent {
    data class OnPinCodeItemClicked(val item: PinCodeItem): PinCodeIntent
}

internal data class PinCodeState(
    val title: String = "",
    val pinCode: String = "",
    val pinCodeDotsState: PinCodeDotsState = PinCodeDotsState.Default,
    val pinCodeItems: List<PinCodeItem> = listOf(),
    val isForgotPinCodeTextVisible: Boolean = false
): BaseState

internal sealed interface PinCodeAction: BaseAction

internal sealed interface PinCodeListener {
    fun onPinCodeItemClick(item: PinCodeItem)
}