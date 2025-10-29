package tonix.app.app_ui_small.navigation.screen.ui.market

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class MarketComponent(
    context: ComponentContext,
    viewModel: MarketViewModel,
    private val navigator: MarketNavigator
): MarketListener, BaseChildComponent<MarketState, MarketIntent, MarketAction, MarketViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe()
}