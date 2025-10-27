package tonix.app.app_ui_small.navigation.screen.ui.operation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class OperationComponent(
    context: ComponentContext,
    viewModel: OperationViewModel,
    private val navigator: OperationNavigator
): OperationListener, BaseChildComponent<OperationState, OperationIntent, OperationAction, OperationViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe()
}