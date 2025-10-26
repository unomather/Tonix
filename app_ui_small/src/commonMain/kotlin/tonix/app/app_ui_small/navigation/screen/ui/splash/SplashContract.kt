package tonix.app.app_ui_small.navigation.screen.ui.splash

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface SplashIntent: BaseIntent

internal sealed interface SplashState: BaseState {
    data object Default: SplashState
}

internal sealed interface SplashAction: BaseAction {
    data object NavigateToCreateImportWallet: SplashAction
}