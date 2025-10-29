package tonix.app.app_ui_small.navigation.screen.ui.market

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface MarketIntent: BaseIntent

internal sealed interface MarketState: BaseState {
    data object Default: MarketState
}

internal sealed interface MarketAction: BaseAction

internal interface MarketListener