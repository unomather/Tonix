package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class CreateImportWalletComponent(
    context: ComponentContext,
    viewModel: CreateImportWalletViewModel,
    private val navigator: CreateImportWalletNavigator
): BaseChildComponent<CreateImportWalletState, CreateImportWalletIntent, CreateImportWalletAction, CreateImportWalletViewModel>(
    context = context,
    viewModel = viewModel
) {
    @Composable
    override fun subscribeState() = subscribe()
}