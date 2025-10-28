package tonix.app.app_ui_small.navigation.screen.ui.assets

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface AssetsIntent: BaseIntent

internal sealed interface AssetsState: BaseState {
    data object Default: AssetsState
}

internal sealed interface AssetsAction: BaseAction

internal interface AssetsListener