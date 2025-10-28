package tonix.app.app_ui_small.navigation.screen.ui.success

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class SuccessComponent(
    context: ComponentContext,
    viewModel: SuccessViewModel,
    private val navigator: SuccessNavigator
): SuccessListener, BaseChildComponent<SuccessState, SuccessIntent, SuccessAction, SuccessViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe()
}