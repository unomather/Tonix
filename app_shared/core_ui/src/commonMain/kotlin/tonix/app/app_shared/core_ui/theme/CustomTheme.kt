package tonix.app.app_shared.core_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.staticCompositionLocalOf
import org.koin.compose.koinInject
import tonix.app.app_shared.core_ui.theme.colors.AppColors
import tonix.app.app_shared.core_ui.theme.colors.data.AppColorsData
import tonix.app.app_shared.core_ui.theme.shape.AppShapes
import tonix.app.app_shared.core_ui.theme.typography.AppTypography
import tonix.app.app_shared.core_ui.theme.window_insets.LocalWindowInsetsData
import tonix.app.app_shared.core_ui.theme.window_insets.getWindowInsets

/**
 * CUSTOM THEME
 */
object CustomTheme {
    val colors: AppColorsData
        @Composable
        get() = LocalAppColorsData.current
    val shapes: AppShapes
        @Composable
        get() = LocalShapes.current
    val typography: AppTypography
        @Composable
        get() = LocalTypography.current
}

/**
 * THEME
 */
@Composable
internal fun ProvideCustomTheme(
    colors: AppColors = koinInject<AppColors>(), // TODO: Use specific useCase with [collectAsState] after MVP
    shapes: AppShapes = koinInject<AppShapes>(),
    typography: AppTypography = koinInject<AppTypography>(),
    windowInsets: LocalWindowInsetsData = getWindowInsets().value,
    content: @Composable () -> Unit
) {
    // App colors
    val colorPalette by rememberUpdatedState(colors.appColorsLight)
    colorPalette.updateColors(colorPalette)
    // App typography
    val appTypography by rememberUpdatedState(typography)
    // App window insets
    val insets by rememberUpdatedState(windowInsets)
    insets.updateInsets(insets)
    // Provider
    CompositionLocalProvider(
        LocalAppColorsData provides colorPalette,
        LocalShapes provides shapes,
        LocalTypography provides appTypography,
        LocalWindowInsets provides insets,
    ) {
        content()
    }
}

/**
 * LOCAL COMPOSITIONS
 */
val LocalAppColorsData = staticCompositionLocalOf<AppColorsData> {
    error("No AppColorsData set")
}
val LocalShapes = staticCompositionLocalOf<AppShapes> {
    error("No AppShapes set")
}
val LocalTypography = staticCompositionLocalOf<AppTypography> {
    error("No AppTypography set")
}
val LocalWindowInsets = staticCompositionLocalOf<LocalWindowInsetsData> {
    error("No LocalWindowInsetsData set")
}