package tonix.app.app_ui_small.navigation.screen.ui.assets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.ic_dropdown
import tonix.app.resources.ic_scan
import tonix.app.resources.ic_settings

@Composable
internal fun AssetsToolbar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 16.dp, start = 6.dp, end = 6.dp)
            .fillMaxWidth()
    ) {
        ToolbarIcon(Res.drawable.ic_scan)
        Spacer(modifier = Modifier.weight(1f))
        ToolbarWallets()
        Spacer(modifier = Modifier.weight(1f))
        ToolbarIcon(Res.drawable.ic_settings)
    }
}

@Composable
private fun ToolbarIcon(
    icon: DrawableResource,
    onClick: () -> Unit = {}
) {
    AppImage(
        image = icon,
        color = colors.text,
        modifier = Modifier
            .size(40.dp)
            .clip(shapes.circle)
            .clickable { onClick() }
            .padding(10.dp)
    )
}

@Composable
private fun ToolbarWallets() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(shapes.extraLarge)
            .background(
                color = colors.backgroundLight,
                shape = shapes.extraLarge
            )
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Wallet",
            color = colors.text,
            style = typography.body1
        )
        AppImage(
            image = Res.drawable.ic_dropdown,
            color = colors.text,
            modifier = Modifier
                .padding(start = 12.dp)
                .size(12.dp)
        )
    }
}