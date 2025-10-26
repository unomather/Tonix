package tonix.app.app_shared.core_ui.theme

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import tonix.app.app_shared.core_ui.theme.colors.AppColorsImpl
import tonix.app.app_shared.core_ui.theme.shape.AppShapesImpl
import tonix.app.app_shared.core_ui.theme.typography.AppTypography
import tonix.app.app_shared.core_ui.theme.typography.AppTypographyImpl

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val fontFamily = getAppFontFamily()
    val typography = koinInject<AppTypography> { parametersOf(fontFamily) }
    ProvideCustomTheme(
        typography = typography,
        content = content
    )
}

@Composable
fun PreviewAppTheme(
    content: @Composable () -> Unit
) {
    ProvideCustomTheme(
        colors = AppColorsImpl(),
        shapes = AppShapesImpl(),
        typography = AppTypographyImpl(getAppFontFamily()),
        content = content
    )
}