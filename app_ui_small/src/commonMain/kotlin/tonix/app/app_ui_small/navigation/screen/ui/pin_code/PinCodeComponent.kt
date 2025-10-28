package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeAction.NavigateBack
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeAction.NavigateToWalletSuccessfullyCreated
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeIntent.OnBackClicked
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.PinCodeIntent.OnPinCodeItemClicked
import tonix.app.app_ui_small.navigation.screen.ui.pin_code.data.PinCodeItem

internal class PinCodeComponent(
    context: ComponentContext,
    viewModel: PinCodeViewModel,
    private val navigator: PinCodeNavigator
): PinCodeListener, BaseChildComponent<PinCodeState, PinCodeIntent, PinCodeAction, PinCodeViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe { action ->
        when (action) {
            is NavigateBack -> navigator.back()
            is NavigateToWalletSuccessfullyCreated -> navigator.toWalletSuccessfullyCreated()
        }
    }

    /**
     * LISTENER
     */
    override fun onBackClick() {
        intent(OnBackClicked)
    }

    override fun onPinCodeItemClick(item: PinCodeItem) {
        intent(OnPinCodeItemClicked(item))
    }
}