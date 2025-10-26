package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletAction.NavigateToCreateWallet
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletAction.NavigateToImportWallet
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletIntent.OnCreateWalletClicked
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletIntent.OnImportWalletClicked
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletState.Default

private typealias S = CreateImportWalletState
private typealias I = CreateImportWalletIntent
private typealias A = CreateImportWalletAction
private typealias Ctx = PipelineContext<S, I, A>

internal class CreateImportWalletViewModel: BaseViewModel<S, I, A>(Default) {
    override suspend fun Ctx.handleIntents(intent: I) {
        when (intent) {
            is OnCreateWalletClicked -> action(NavigateToCreateWallet)
            is OnImportWalletClicked -> action(NavigateToImportWallet)
        }
    }
}