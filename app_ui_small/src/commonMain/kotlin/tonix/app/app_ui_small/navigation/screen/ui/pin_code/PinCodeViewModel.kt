package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import org.jetbrains.compose.resources.getString
import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.*
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.getPinCodeItems
import tonix.app.resources.Res
import tonix.app.resources.check_pin_code
import tonix.app.resources.create_pin_code
import tonix.app.resources.repeat_pin_code

private typealias Ctx = PipelineContext<PinCodeState, PinCodeIntent, PinCodeAction>

internal class PinCodeViewModel(
    private val pinCodeMode: PinCodeMode
): BaseViewModel<PinCodeState, PinCodeIntent, PinCodeAction>(PinCodeState()) {
    /**
     * INIT
     */
    override suspend fun Ctx.init() {
        buildPinCodeItems()
        setTitle()
        setIsForgotPinCodeTextVisible()
    }

    /**
     * PIN CODE GRID ITEMS
     */
    private fun Ctx.buildPinCodeItems() = io {
        val items = getPinCodeItems(pinCodeMode)
        updateState { copy(pinCodeItems = items) }
    }

    /**
     * TITLE
     */
    private fun Ctx.setTitle() = io {
        val titleResId = when (pinCodeMode) {
            CREATE -> Res.string.create_pin_code
            REPEAT -> Res.string.repeat_pin_code
            CHECK, CHANGE -> Res.string.check_pin_code
        }
        updateState { copy(title = getString(titleResId)) }
    }

    /**
     * FORGOT PIN CODE
     */
    private fun Ctx.setIsForgotPinCodeTextVisible() = io {
        updateState { copy(isForgotPinCodeTextVisible = pinCodeMode == CHECK) }
    }
}