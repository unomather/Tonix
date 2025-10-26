package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface CreateImportWalletIntent: BaseIntent

internal sealed interface CreateImportWalletState: BaseState {
    data object Default: CreateImportWalletState
}

internal sealed interface CreateImportWalletAction: BaseAction

internal interface CreateImportWalletListener