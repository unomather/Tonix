package tonix.app.app_ui_small.navigation.screen.ui.assets.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.current_balance

@Composable
internal fun AssetsBalance() {
    Text(
        text = stringResource(Res.string.current_balance),
        color = colors.text.copy(alpha = 0.5f),
        style = typography.body1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    )
    Text(
        text = "$45,404.00",
        color = colors.text,
        style = typography.h1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    )
}