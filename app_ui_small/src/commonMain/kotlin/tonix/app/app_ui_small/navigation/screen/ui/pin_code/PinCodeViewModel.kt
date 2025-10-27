package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.getString
import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeIntent.OnPinCodeItemClicked
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeDotsState.Default
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeDotsState.Error
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeDotsState.Success
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.EmptySpace
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeDigit
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon.Biometry
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem.PinCodeIcon.RemoveDigit
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.CHANGE
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.CHECK
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.CREATE
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeMode.REPEAT
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
     * DATA
     */
    private var currentPinCodeMode = pinCodeMode
    private var previousEnteredPinCode = ""

    /**
     * INIT
     */
    override suspend fun Ctx.init() {
        buildPinCodeItems()
        setTitle()
        setIsForgotPinCodeTextVisible()
    }

    override suspend fun Ctx.handleIntents(intent: PinCodeIntent) {
        when (intent) {
            is OnPinCodeItemClicked -> handleOnPinCodeItemClicked(intent.item)
        }
    }

    /**
     * PIN CODE GRID ITEMS
     */
    private fun Ctx.buildPinCodeItems() = io {
        val items = getPinCodeItems(pinCodeMode)
        updateState { copy(pinCodeItems = items) }
    }

    private fun Ctx.handleOnPinCodeItemClicked(item: PinCodeItem) = io {
        withState {
            when (item) {
                is PinCodeDigit -> updateState { copy(pinCode = "$pinCode${item.value}") }
                is RemoveDigit -> updateState { copy(pinCode = pinCode.dropLast(1)) }
                EmptySpace, Biometry -> Unit
            }
            handleModeChanging()
        }
    }

    private suspend fun Ctx.handleModeChanging() = withState {
        if (pinCode.length == PIN_CODE_LENGTH) {
            delay(300) // last pin color animation
            when (currentPinCodeMode) {
                CREATE -> {
                    previousEnteredPinCode = pinCode
                    currentPinCodeMode = REPEAT
                    updateState { copy(pinCode = "", title = getTitle()) }
                }
                REPEAT -> if (pinCode == previousEnteredPinCode) {
                    updateState { copy(pinCodeDotsState = Success) }
                } else {
                    currentPinCodeMode = pinCodeMode
                    updateState { copy(pinCodeDotsState = Error("Pin codes do not match")) }
                    delay(1500)
                    updateState { copy(pinCodeDotsState = Default, pinCode = "", title = getTitle()) }

                }
                else -> Unit
            }
        }
    }

    /**
     * TITLE
     */
    private fun Ctx.setTitle() = io {
        updateState { copy(title = getTitle()) }
    }

    private suspend fun getTitle() = when (currentPinCodeMode) {
        CREATE -> Res.string.create_pin_code
        REPEAT -> Res.string.repeat_pin_code
        CHECK, CHANGE -> Res.string.check_pin_code
    }.let { titleRes ->
        getString(titleRes)
    }

    /**
     * FORGOT PIN CODE
     */
    private fun Ctx.setIsForgotPinCodeTextVisible() = io {
        updateState { copy(isForgotPinCodeTextVisible = pinCodeMode == CHECK) }
    }
}