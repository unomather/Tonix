package tonix.app.app_ui_small.navigation.screen.ui.dapps

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class DAppsComponent(
    context: ComponentContext,
    viewModel: DAppsViewModel,
    private val navigator: DAppsNavigator
): DAppsListener, BaseChildComponent<DAppsState, DAppsIntent, DAppsAction, DAppsViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe()
}