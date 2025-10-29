package tonix.app.app_ui_small.navigation.screen.ui.assets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_ui_small.navigation.screen.ui.assets.ui.AssetsBalance
import tonix.app.app_ui_small.navigation.screen.ui.assets.ui.AssetsSendReceiveExchangeButtons
import tonix.app.app_ui_small.navigation.screen.ui.assets.ui.AssetsToolbar
import tonix.app.app_ui_small.navigation.screen.ui.assets.ui.MyAssets

@Composable
internal fun AssetsMainScreen(
    state: AssetsState,
    listener: AssetsListener?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        AssetsToolbar()
        AssetsBalance()
        AssetsSendReceiveExchangeButtons()
        MyAssets()
    }
}