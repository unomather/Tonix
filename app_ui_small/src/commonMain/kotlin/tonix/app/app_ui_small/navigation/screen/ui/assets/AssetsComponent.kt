package tonix.app.app_ui_small.navigation.screen.ui.assets

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class AssetsComponent(
    context: ComponentContext,
    viewModel: AssetsViewModel,
    private val navigator: AssetsNavigator
): AssetsListener, BaseChildComponent<AssetsState, AssetsIntent, AssetsAction, AssetsViewModel>(
    context = context,
    viewModel = viewModel
) {
    @Composable
    override fun subscribeState() = subscribe()
}