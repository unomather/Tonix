package tonix.app.app_ui_small.navigation.screen.ui.create_import_wallet

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
context(transition: SharedTransitionScope, visibility: AnimatedVisibilityScope)
internal fun CreateImportWalletMainScreen(state: CreateImportWalletState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.accent)
    )
}