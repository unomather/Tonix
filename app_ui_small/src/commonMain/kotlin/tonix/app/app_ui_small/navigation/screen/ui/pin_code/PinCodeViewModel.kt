package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.CHECK
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.getPinCodeItems

private typealias Ctx = PipelineContext<PinCodeState, PinCodeIntent, PinCodeAction>

internal class PinCodeViewModel(
    private val pinCodeMode: PinCodeMode
): BaseViewModel<PinCodeState, PinCodeIntent, PinCodeAction>(PinCodeState()) {
    /**
     * INIT
     */
    override suspend fun Ctx.init() {
        buildPinCodeItems()
        showHideForgotPinCodeText()
    }

    /**
     * PIN CODE GRID ITEMS
     */
    private fun Ctx.buildPinCodeItems() = io {
        val items = getPinCodeItems(pinCodeMode)
        updateState { copy(pinCodeItems = items) }
    }

    /**
     * FORGOT PIN CODE
     */
    private fun Ctx.showHideForgotPinCodeText() = io {
        updateState { copy(isForgotPinCodeTextVisible = pinCodeMode == CHECK) }
    }
}