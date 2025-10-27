package tonix.app.app_shared.core_ui.components.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes
import tonix.app.app_shared.core_ui.theme.CustomTheme.typography
import tonix.app.resources.Res
import tonix.app.resources.ic_back

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title: StringResource? = null,
    description: StringResource? = null,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.background)
    ) {
        ToolbarBackIcon(onBackClick)
        if (title != null) {
            ToolbarTitle(title)
        }
        if (description != null) {
            ToolbarDescription(description)
        }
    }
}

@Composable
fun ToolbarBackIcon(onBackClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(start = 6.dp)
            .size(48.dp)
            .clip(shapes.circle)
            .clickable { onBackClick() }
    ) {
        AppImage(
            image = Res.drawable.ic_back,
            color = colors.text,
            modifier = Modifier
                .size(28.dp)
                .clip(shapes.circle)
                .background(
                    color = colors.backgroundLight,
                    shape = shapes.circle
                )
                .padding(8.dp)
        )
    }
}

@Composable
fun ToolbarTitle(title: StringResource) {
    Text(
        text = stringResource(title),
        color = colors.text,
        style = typography.h3,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ToolbarDescription(description: StringResource) {
    Text(
        text = stringResource(description),
        color = colors.text.copy(alpha = 0.5f),
        style = typography.body1,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 16.dp, start = 32.dp, end = 32.dp)
            .fillMaxWidth()
    )
}