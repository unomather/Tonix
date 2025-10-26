package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletAction.NavigateToCreateWallet
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletAction.NavigateToImportWallet
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletIntent.OnCreateWalletClicked
import tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet.CreateImportWalletIntent.OnImportWalletClicked

internal class CreateImportWalletComponent(
    context: ComponentContext,
    viewModel: CreateImportWalletViewModel,
    private val navigator: CreateImportWalletNavigator
): CreateImportWalletListener, BaseChildComponent<CreateImportWalletState, CreateImportWalletIntent, CreateImportWalletAction, CreateImportWalletViewModel>(
    context = context,
    viewModel = viewModel
) {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe { action ->
        when (action) {
            is NavigateToCreateWallet -> navigator.toCreateWallet()
            is NavigateToImportWallet -> navigator.toImportWallet()
        }
    }

    /**
     * LISTENER
     */
    override fun onCreateWalletClick() {
        intent(OnCreateWalletClicked)
    }

    override fun onImportWalletClick() {
        intent(OnImportWalletClicked)
    }
}