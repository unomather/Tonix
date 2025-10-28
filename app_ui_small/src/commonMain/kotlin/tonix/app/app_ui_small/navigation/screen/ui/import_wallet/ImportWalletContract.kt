package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import tonix.app.app_shared.core_ui.view_model.base.BaseAction
import tonix.app.app_shared.core_ui.view_model.base.BaseIntent
import tonix.app.app_shared.core_ui.view_model.base.BaseState

internal sealed interface ImportWalletIntent: BaseIntent {
    data object OnBackClicked: ImportWalletIntent
    data object OnContinueClicked: ImportWalletIntent
}

internal sealed interface ImportWalletState: BaseState {
    data object Default: ImportWalletState
}

internal sealed interface ImportWalletAction: BaseAction {
    data object NavigateBack: ImportWalletAction
    data object NavigateToWalletSuccessfullyImported: ImportWalletAction
}

internal interface ImportWalletListener {
    fun onBackClick()
    fun onContinueClick()
}