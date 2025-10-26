package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import tonix.app.app_shared.core_ui.view_model.BaseViewModel

internal class ImportWalletViewModel: BaseViewModel<ImportWalletState, ImportWalletIntent, ImportWalletAction>(
    initialValue = ImportWalletState.Default
)