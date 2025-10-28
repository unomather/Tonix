package tonix.app.app_ui_small.navigation.screen.ui.assets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors

@Composable
internal fun AssetsMainScreen(
    state: AssetsState,
    listener: AssetsListener?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {

    }
}