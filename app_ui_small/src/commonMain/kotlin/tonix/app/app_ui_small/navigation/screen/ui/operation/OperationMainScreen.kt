package tonix.app.app_ui_small.navigation.screen.ui.operation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors

@Composable
internal fun OperationMainScreen(
    state: OperationState,
    listener: OperationListener?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.accent)
    )
}