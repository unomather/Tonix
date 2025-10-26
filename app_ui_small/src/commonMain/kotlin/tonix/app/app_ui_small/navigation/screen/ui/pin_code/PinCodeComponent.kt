package tonix.app.app_ui_small.navigation.screen.ui.pin_code

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

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
    override fun subscribeState() = subscribe()
}