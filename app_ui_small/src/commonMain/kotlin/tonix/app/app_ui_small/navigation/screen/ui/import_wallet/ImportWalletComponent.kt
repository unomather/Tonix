package tonix.app.app_ui_small.navigation.screen.ui.import_wallet

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import pro.respawn.flowmvi.compose.dsl.subscribe
import tonix.app.app_ui_small.navigation.base.BaseChildComponent

internal class ImportWalletComponent(
    context: ComponentContext,
    viewModel: ImportWalletViewModel,
    private val navigator: ImportWalletNavigator
): BaseChildComponent<ImportWalletState, ImportWalletIntent, ImportWalletAction, ImportWalletViewModel>(
    context = context,
    viewModel = viewModel
) {
    @Composable
    override fun subscribeState() = subscribe()
}