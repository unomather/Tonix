package tonix.app.app_ui_small.navigation.screen.ui.success.data

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenData.WalletSuccessfullyCreated
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenData.WalletSuccessfullyImported
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenType.WALLET_SUCCESSFULLY_CREATED
import tonix.app.app_ui_small.navigation.screen.ui.success.data.SuccessScreenType.WALLET_SUCCESSFULLY_IMPORTED
import tonix.app.resources.Res
import tonix.app.resources.`continue`
import tonix.app.resources.done
import tonix.app.resources.wallet_created_success
import tonix.app.resources.wallet_imported_success

@Immutable
internal sealed class SuccessScreenData(
    val title: StringResource,
    val description: StringResource,
    val buttonText: StringResource
) {
    @Immutable
    data object WalletSuccessfullyCreated: SuccessScreenData(
        title = Res.string.done,
        description = Res.string.wallet_created_success,
        buttonText = Res.string.`continue`
    )

    @Immutable
    data object WalletSuccessfullyImported: SuccessScreenData(
        title = Res.string.done,
        description = Res.string.wallet_imported_success,
        buttonText = Res.string.`continue`
    )
}

internal fun getSuccessScreenDataByType(type: SuccessScreenType) = when (type) {
    WALLET_SUCCESSFULLY_CREATED -> WalletSuccessfullyCreated
    WALLET_SUCCESSFULLY_IMPORTED -> WalletSuccessfullyImported
}