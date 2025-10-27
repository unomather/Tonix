package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import pro.respawn.flowmvi.api.PipelineContext
import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletAction.NavigateBack
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletIntent.OnBackClicked

private typealias Ctx = PipelineContext<ImportWalletState, ImportWalletIntent, ImportWalletAction>

internal class ImportWalletViewModel: BaseViewModel<ImportWalletState, ImportWalletIntent, ImportWalletAction>(
    initialValue = ImportWalletState.Default
) {
    override suspend fun Ctx.handleIntents(intent: ImportWalletIntent) {
        when (intent) {
            is OnBackClicked -> action(NavigateBack)
        }
    }
}