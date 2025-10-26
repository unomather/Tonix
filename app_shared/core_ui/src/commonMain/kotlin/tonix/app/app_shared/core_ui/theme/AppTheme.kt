package tonix.app.app_shared.core_ui.theme

import androidx.compose.runtime.Composable
import tonix.app.app_shared.core_ui.theme.colors.AppColorsImpl
import tonix.app.app_shared.core_ui.theme.shape.AppShapesImpl
import tonix.app.app_shared.core_ui.theme.typography.AppTypographyImpl

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    ProvideCustomTheme { content() }
}

@Composable
fun PreviewAppTheme(
    content: @Composable () -> Unit
) {
    ProvideCustomTheme(
        colors = AppColorsImpl(),
        shapes = AppShapesImpl(),
        typography = AppTypographyImpl(),
        content = content
    )
}