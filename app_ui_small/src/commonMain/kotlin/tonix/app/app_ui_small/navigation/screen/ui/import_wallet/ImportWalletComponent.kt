package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletAction.NavigateBack
import tonix.app.app_ui_small.navigation.screen.ui.import_wallet.ImportWalletIntent.OnBackClicked

internal class ImportWalletComponent(
    context: ComponentContext,
    viewModel: ImportWalletViewModel,
    private val navigator: ImportWalletNavigator
): BaseChildComponent<ImportWalletState, ImportWalletIntent, ImportWalletAction, ImportWalletViewModel>(
    context = context,
    viewModel = viewModel
), ImportWalletListener {
    /**
     * STATE
     */
    @Composable
    override fun subscribeState() = subscribe { action ->
        when (action) {
            is NavigateBack -> navigator.back()
        }
    }

    /**
     * LISTENER
     */
    override fun onBackClick() {
        intent(OnBackClicked)
    }
}