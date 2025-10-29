package tonix.app.app_shared.core_ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import tonix.app.app_shared.core_ui.components.button.AppButtonState.ACCENT
import tonix.app.app_shared.core_ui.components.button.AppButtonState.ACCENT_PROGRESS
import tonix.app.app_shared.core_ui.components.button.AppButtonState.DEFAULT
import tonix.app.app_shared.core_ui.components.button.AppButtonState.DEFAULT_PROGRESS
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography

@Composable
fun AppButton(
    text: String,
    startIcon: DrawableResource? = null,
    state: AppButtonState,
    onClick: () -> Unit = {},
    modifier: Modifier
) {
    val backgroundColors = when (state) {
        ACCENT, ACCENT_PROGRESS -> colors.accent
        DEFAULT, DEFAULT_PROGRESS -> colors.backgroundLight
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(shapes.extraLarge)
            .background(
                shape = shapes.extraLarge,
                color = backgroundColors
            )
            .clickable(
                enabled = state == ACCENT || state == DEFAULT,
                onClick = onClick
            )
    ) {
        when (state) {
            ACCENT_PROGRESS, DEFAULT_PROGRESS -> CircularProgressIndicator(
                strokeWidth = 2.dp,
                color = colors.text,
                trackColor = colors.text,
                modifier = Modifier.size(20.dp)
            )
            ACCENT, DEFAULT -> Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (startIcon != null) {
                    AppImage(
                        image = startIcon,
                        color = colors.text,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(12.dp)
                    )
                }
                Text(
                    text = text,
                    color = colors.text,
                    style = typography.body1
                )
            }
        }
    }
}