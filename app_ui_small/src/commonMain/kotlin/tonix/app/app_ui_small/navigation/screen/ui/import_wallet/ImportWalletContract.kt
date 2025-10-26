package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface ImportWalletIntent: BaseIntent

internal sealed interface ImportWalletState: BaseState {
    data object Default: ImportWalletState
}

internal sealed interface ImportWalletAction: BaseAction