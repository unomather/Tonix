package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import tonix.app.app_shared.core_ui.view_model.BaseViewModel
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletState.Default

private typealias S = CreateImportWalletState
private typealias I = CreateImportWalletIntent
private typealias A = CreateImportWalletAction

internal class CreateImportWalletViewModel: BaseViewModel<S, I, A>(Default)