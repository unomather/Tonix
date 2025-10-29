package tonix.app.app_ui_small.navigation.screen.ui.dapps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors

@Composable
internal fun DAppsMainScreen(
    state: DAppsState,
    listener: DAppsListener?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    )
}